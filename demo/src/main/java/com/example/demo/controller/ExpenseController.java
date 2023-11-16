package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.service.ExpenseService;

@Controller
public class ExpenseController {

    private static final Object ExpenseEntity = null;
	@Autowired
    private ExpenseService expenseService;
    /**
     * 経費一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/expense/list")
    public String displayList(Model model) {
        List<ExpenseEntity> expenselist = expenseService.searchAll();
        model.addAttribute("expenselist", expenselist);
        return "expense/list";
    }

    /**
     * 経費新規登録画面を表示
     * @param model Model
     * @return 経費情報一覧画面
     */
    @GetMapping("/expense/add")
    public String displayAdd(Model model) {
      model.addAttribute("expenseRequest", new ExpenseRequest());
    return "expense/add";
    }
    /**
     * データベースへの登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return 経費一覧画面
     */
    @RequestMapping(value = "expense/complete", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute ExpenseRequest expenseRequest, BindingResult result, Model model) {

    	if (result.hasErrors()) {
        // 入力チェックエラーの場合
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "expense/add";
      }
      // 経費情報の登録
      expenseService.update(expenseRequest);
      return "expense/complete";
    }
    
    @GetMapping("expense/complete") // 申請完了画面のエンドポイント
    public String  getcomplete(Model model) {
        return "expense/complete"; // 申請完了画面のHTMLファイル名を指定
    }


	public static Object getExpenseentity() {
		return ExpenseEntity;
	}
  
}
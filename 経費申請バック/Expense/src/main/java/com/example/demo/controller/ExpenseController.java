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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.service.ExpenseService;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private static final Object ExpenseEntity = null;
	@Autowired
    private ExpenseService expenseService;
    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/expense/list")
    public ModelAndView displayList(Model model) {
        List<ExpenseEntity> expenselist = expenseService.searchAll();
        model.addAttribute("expenslist", expenselist);
        return new ModelAndView("expense/list");
    }

    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("/expense/add")
    public String displayAdd(Model model) {
      model.addAttribute("expenseRequest", new ExpenseEntity());
    return "expense/add";
    }
    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("/expense/create")
    public String create(@Validated @ModelAttribute ExpenseEntity expenseEntityt, BindingResult result, Model model) {
      if (result.hasErrors()) {
        // 入力チェックエラーの場合
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "expense/add";
      }
      // ユーザー情報の登録
      expenseService.create(expenseService);
      return "/expense/list";
    }

    /**
     * ユーザー情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/expense/{id}")
    public String displayView(@PathVariable Long id, Model model) {
      return "expense/view";
    }

	public static Object getExpenseentity() {
		return ExpenseEntity;
	}
  
}
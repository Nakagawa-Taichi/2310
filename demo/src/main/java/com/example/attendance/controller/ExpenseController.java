package com.example.attendance.controller;


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

import com.example.attendance.dto.ExpenseRequest;
import com.example.attendance.entity.ExpenseEntity;
import com.example.attendance.service.ExpenseService;

@Controller
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
    public String displayList(Model model) {
        List<ExpenseEntity> expenselist = expenseService.searchAll();
        model.addAttribute("expenslist", expenselist);
        return "expense/list";
    }

    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping("/expense/add")
    public String displayAdd(Model model) {
      model.addAttribute("expenseRequest", new ExpenseRequest());
    return "expense/add";
    }
    /**
     * データベースにへの登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value ="/expense/create", method = RequestMethod.POST)
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
      // ユーザー情報の登録
      expenseService.create(expenseRequest);
      return "redirect/expense/list";
    }

	public static Object getExpenseentity() {
		return ExpenseEntity;
	}
  
}
package com.example.attendance.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.attendance.dto.ExpenseUpdateRequest;
import com.example.attendance.entity.ExpenseEntity;
import com.example.attendance.service.ExpenseService;

/**
 * 経費に関するController
 */
@Controller
@RequestMapping("/expense")
public class ExpenseController {
	
	/**
	 * 経費のService
	 */
	@Autowired  
	private ExpenseService expenseService;

	/**
	 * 経費編集画面を表示
	 * @param id 表示する経費ID
	 * @param model Model
	 * @return 経費編集画面のパス
	 */
	@GetMapping("/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
	    ExpenseEntity expense = expenseService.findById(id);
	    if (expense.getApplicationDate() != null) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = dateFormat.format(expense.getApplicationDate());
	        model.addAttribute("formattedApplicationDate", formattedDate);
	    }
	    
	    model.addAttribute("expenseEntity", expense);
	    return "expense/edit";
	}
	
	/**
	 * 経費編集
	 * @param id 編集する経費のID
	 * @param expenseRequest リクエストデータ
	 * @param result BindingResult
	 * @param model Model
	 * @return 経費一覧へのリダイレクト
	 */
	@PostMapping("/{id}/edit")
	public String update(@PathVariable Long id, 
	                     @Validated @ModelAttribute("expenseUpdateRequest") ExpenseUpdateRequest expenseUpdateRequest, 
	                     BindingResult result, 
	                     Model model) {
	  if (result.hasErrors()) {
	    List<String> errorList = new ArrayList<String>();
	    for (ObjectError error : result.getAllErrors()) {
	      errorList.add(error.getDefaultMessage());
	    }
	    model.addAttribute("validationError", errorList);
	    return "expense/edit";
	  }
	  
	  expenseUpdateRequest.setId(id);

	  // 経費情報の更新
	  expenseService.update(expenseUpdateRequest);
	  return "redirect:/expense/list";
	}
}

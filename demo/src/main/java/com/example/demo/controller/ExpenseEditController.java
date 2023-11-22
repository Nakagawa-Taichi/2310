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
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ExpenseUpdateRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.service.ExpenseEditService;

@Controller
public class ExpenseEditController {

	@Autowired
	private ExpenseEditService expenseEditService;
	
    /**
     * 経費情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return 経費情報詳細画面
     */
    @GetMapping("/expense/{id}")
    public String displayView(@PathVariable Long id, Model model) {
      ExpenseEntity expense = expenseEditService.findById(id);
      model.addAttribute("expenseData", expense);
      return "expense/view";
    }
	
    /**
     * 経費編集画面を表示
     * @param id 表示する経費ID
     * @param model Model
     * @return 経費編集画面
     */
    @GetMapping("/expense/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {
        ExpenseEntity expense = expenseEditService.findById(id);
        ExpenseUpdateRequest expenseUpdateRequest = new ExpenseUpdateRequest();
        expenseUpdateRequest.setId(expense.getId());
        expenseUpdateRequest.setCategory(expense.getExpenseCategory());
        expenseUpdateRequest.setAmount(expense.getAmount());
        expenseUpdateRequest.setDescription(expense.getDescription());
        model.addAttribute("expenseUpdateRequest", expenseUpdateRequest);
        return "expense/edit";
    }

    /**
     * 経費更新
     * @param expenseRequest リクエストデータ
     * @param model Model
     * @return 経費一覧画面
     */
    @RequestMapping(value = "/expense/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute ExpenseUpdateRequest expenseUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "expense/edit";
          }
      // ユーザー情報の更新
      expenseEditService.update(expenseUpdateRequest);
      return "expense/list";
    }
    
    /**
     * 経費情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return 経費一覧画面
     */
    @GetMapping("/expense/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
      // ユーザー情報の削除
      expenseEditService.delete(id);
      return "redirect:/expense/list";
    }
}
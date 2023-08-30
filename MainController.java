package com.caroline.savetravels.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caroline.savetravels.models.Expense;
import com.caroline.savetravels.services.ExpenseService;

import jakarta.validation.Valid;


@Controller
public class MainController {
	
	@Autowired 
	private ExpenseService expenseService;
	
	@RequestMapping("/")
	public String home () {
		return "redirect:/expenses";
	}
	
	
	// this route will create a blank sheet of paper that allExpenses from the repository are going to be attached
	@GetMapping("/expenses") 
	public String addListOfSavedExpenses(@ModelAttribute("newExpense") Expense expense, Model model) { 
		
		List<Expense> allExpenses = expenseService.readAllExpenses(); // allExpenses: variable that will receive a list of all expenses stored in DB
		model.addAttribute("allExpenses", allExpenses); //the blank sheet of paper is receiving allExpenses List
		
		return "index.jsp";
	}
	
	
	// this route is validating the user's answers and binding all the parameters passed by the user throw the form to the object that was already instantiated by the Model
	@PostMapping("/saveexpenses")
	public String submitExpenseToDataBase (@Valid @ModelAttribute ("newExpense") Expense newExpense, BindingResult result, Model viewModel) {
		
		if (result.hasErrors()) { //If the parameters doesn't match with the validation in the model, it will return to the first page
			return "index.jsp";
			}
		else {
			expenseService.createExpense(newExpense); // the controller send a message to the service to create a new expense
			
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}/edit") // this route is going to show the edit form by Id
	public String showEditForm(@PathVariable ("id") long id, Model viewModel) {//path the variable id from the form and creating the blank sheet of paper just with the id number
		
		
		Expense showExpense = expenseService.getThisExpense(id);
		viewModel.addAttribute("thisExpense", showExpense);
		
			
		return "edit_expense.jsp";
	}
	
	
	@PutMapping("expenses/{id}/update") // this route will get the id from the edit form, create a sheet blank paper with the id and bind all the information passed by the user
	public String updateExpense (@Valid @ModelAttribute ("thisExpense") Expense thisExpense, BindingResult result, Model viewModel) {
		if (result.hasErrors()) { //If the parameters doesn't match with the validation in the model, it will return to the edit page
			
			return "edit_expense.jsp";
			}
		else {
			viewModel.addAttribute("thisExpense", thisExpense);
			expenseService.createExpense(thisExpense); // the controller send a message to the service to update the expense
			
			return "redirect:/expenses";
		}
	}
	
	
		@DeleteMapping("/expenses/{id}/delete")
		public String deleteExpense(@PathVariable("id") Long id) {
			
			expenseService.deleteExpense(id);
				return "redirect:/"; // redirecting to a RequestMethod
		}
		
		
		// this route get a variable id from the page and call the service to show the entire object 
		@GetMapping("/expenses/{id}/show") 
		public String detailsExpense(@PathVariable ("id") Long id, Model viewModel) {
			
				Expense showExpense = expenseService.getThisExpense(id);
				viewModel.addAttribute("thisExpense", showExpense);
				return "details.jsp";
		} 
}
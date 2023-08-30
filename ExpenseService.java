package com.caroline.savetravels.services;




import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.caroline.savetravels.models.Expense;
import com.caroline.savetravels.repositories.ExpenseRepository;



@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository; //injecting the ExpenseRepository


	// The constructor that allows the ExpenseService to receive the message from the expenseRepository
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// this method allows the service to create a new expense and send to repository to save 
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
		
	}
	
	// show all expenses
	public List <Expense> readAllExpenses() {
		return expenseRepository.findAll();
	}
	
	// this method allows the service to update the expense when the id is the parameter ("creating another object using the same id")
	public Expense createExpense(Long id) {
		return expenseRepository.save(id);
	}
	
	// this method allows the service to get an expense by id (to manage the expense)
	public Expense getThisExpense(Long id) {
		Optional <Expense> presentOrNot = expenseRepository.findById(id);
			if (presentOrNot.isPresent()){
				return presentOrNot.get();
			}
			else {
				return null;
			}
	}
	
	// this method allows the service to update an expense
	public Expense updateExpense(Expense thisExpense) {
		return expenseRepository.save(thisExpense);
		
	}
	
	// this method allows to send a message to repository to delete an expense 
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
	/*//this method send a message to the repository to show all the information by id
	public Optional<Expense> showDetails(Long id) {
		return expenseRepository.findById(id);
	}*/
}


	

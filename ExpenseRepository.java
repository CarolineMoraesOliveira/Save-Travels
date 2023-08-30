package com.caroline.savetravels.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caroline.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository <Expense, Long>{
	
	<S extends Expense> S save(S expense);// this method saves the newExpense into the DB
	
	List <Expense> findAll(); // Grab all the expenses stored on database
	
	Expense save(Long id); // Save on DB when you already have an id (update method)
	
	Optional<Expense> findById(Long id); //return all the instances but the ID
}
	
package com.caroline.savetravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date ();
		this.updatedAt = new Date ();
		
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@NotBlank (message = "This field can not be empty")
	@Size(min = 2, max = 200)
	String expense;
	
	@NotBlank (message = "This field can not be empty")
	@Size(min = 1, max = 200)
	String vendor;
	
	@NotNull (message = "This field needs to be a number greater than zero ")
	@Min(value = 1) 
	double amount;
	
	@NotBlank (message = "This field can not be empty")
	@Size(min = 1, max = 200)
	String description;
	
	// The constructor to do a new object Expense
	public Expense() {
		
	}
	
	// The constructor that allows to make an entire Expense object
	public Expense (String expense, String vendor, double amount, String description) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	// getters and setters to access my objects
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
}
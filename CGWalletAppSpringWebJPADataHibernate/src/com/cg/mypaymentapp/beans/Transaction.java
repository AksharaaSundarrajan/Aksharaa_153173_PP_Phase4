package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String mobileNumber;
	private String dateOfTransaction;
	private String transactionType;
	private String transactionStatus;
	private BigDecimal amount;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}


	public Transaction() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Transaction(String mobileNumber, String dateOfTransaction, String transactionType, String transactionStatus,
			BigDecimal amount) {
		super();
		this.mobileNumber = mobileNumber;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.amount = amount;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getDateOfTransaction() {
		return dateOfTransaction;
	}


	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	@Override
	public String toString() {
		return "Transaction [mobileNumber=" + mobileNumber + ", dateOfTransaction=" + dateOfTransaction
				+ ", transactionType=" + transactionType + ", transactionStatus=" + transactionStatus + ", amount="
				+ amount + "]";
	}
	
	
	
}

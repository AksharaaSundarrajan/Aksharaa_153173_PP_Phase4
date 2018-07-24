package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;


public interface WalletService {
	Customer createAccount(Customer customer);
	Customer showBalance (String mobileno);
	Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	Customer depositAmount (String mobileNo,BigDecimal amount );
	Customer withdrawAmount(String mobileNo, BigDecimal amount);
	List<Transaction> getTransactionDetails(String number);
	void setCustomer1(Customer cust);
	void setCustomer(Customer cust);
	Customer getCustomer();
	Customer getCustomer1();
	List<Customer> getAllCustomerDetails();
	List<Customer> filterMinimumBalance();
}

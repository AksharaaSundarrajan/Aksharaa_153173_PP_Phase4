package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;

@Controller
public class URIController {

	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexpage";
	}
	@RequestMapping(value="/login")
	public String getLoginPage() {
		return "loginPage";
	}
	@RequestMapping(value="/registration")
	public String getRegistrationPage()	{
		return "registrationPage";
	}
	@RequestMapping(value="/withdrawAmount")
	public String getWithdrawalPage() {
		return "withdrawAmount";
	}
	@RequestMapping(value="/depositAmount")
	public String getDepositPage() {
		return "depositAmount";
	}
	@RequestMapping(value="/fundTransfer")
	public String getFundTransferPage()	{
		return "fundTransfer";
	}
	@RequestMapping(value="/logout")
	public String getLogoutPage()	{
		return "logout";
	}
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	@ModelAttribute("transactions")
	public Transaction getTransactions() {
		return new Transaction();
	}
}

package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.exception.CustomerDetailsNotFound;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired
	WalletService wService;

	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result) {
		Customer cust = new Customer();
		try {
			if(result.hasErrors()) return new ModelAndView("registrationPage");
			cust =wService.createAccount(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("registrationSuccess","customer",cust);
	}
	@RequestMapping(value="/customerLogin")
	public ModelAndView customerLogin(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@Param("mobileNo")String mobileNo) {
		
		try {
			Customer cust = new Customer();
			cust = wService.showBalance(mobileNo);
			wService.setCustomer(cust);
			return new ModelAndView("loggedIn","customer",cust);
		} catch (CustomerDetailsNotFound e) {
			return new ModelAndView("loginPage","errorMessage",e.getMessage());
		}
	}
	@RequestMapping(value="/showBalance")
	public ModelAndView showBalance() {
		return new ModelAndView("showBalance","customer",wService.getCustomer());

	}
	@RequestMapping(value="/depositWallet")
	public ModelAndView depositWallet(@RequestParam("wallet.balance")BigDecimal amount) {
		/*System.out.println(wService.getCustomer().getMobileNo());
		System.out.println(amount);*/
		wService.depositAmount(wService.getCustomer().getMobileNo(), amount);

		return new ModelAndView("showBalance","customer",wService.getCustomer());
	}
	@RequestMapping(value="/withdrawWallet")
	public ModelAndView withdrawWallet(@Valid @ModelAttribute("customer")Customer customer,BindingResult result, @RequestParam("wallet.balance")BigDecimal amount) {
		System.out.println(wService.getCustomer());
		try {
			Customer cust =wService.withdrawAmount(wService.getCustomer().getMobileNo(), amount);
			return new ModelAndView("showBalance","customer",cust);
		} catch (InsufficientBalanceException e) {
			return new ModelAndView("withdrawAmount","errorMessage",e.getMessage());
		}
		
	}
	@RequestMapping(value="/retrieveAllTransactions")
	public ModelAndView retrieveAllTransactions() {
		List<Transaction> tList=new ArrayList<>();
		tList = wService.getTransactionDetails(wService.getCustomer().getMobileNo());
		return new ModelAndView("retrieveAllTransactions","transactions",tList);
	}
	@RequestMapping(value="/retrieveAllCustomers")
	public ModelAndView retrieveAllCustomers() {
		List<Customer> cList=new ArrayList<>();
		cList = wService.getAllCustomerDetails();
		return new ModelAndView("retrieveAllCustomers","customer",cList);
	}
	@RequestMapping(value="/retrieveAllWithMinBalance")
	public ModelAndView retrieveAllWithMinBalance() {
		List<Customer> cList=new ArrayList<>();
		cList = wService.filterMinimumBalance();
		return new ModelAndView("retrieveAllCustomers","customer",cList);
	}
	@RequestMapping(value="/fundTransferWallet")
	public ModelAndView fundTransferWallet(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,@RequestParam("wallet.balance")BigDecimal amount, @RequestParam("mobileNo")String mobileNo){
		Customer cust = new Customer();
		try {
			cust=wService.showBalance(mobileNo);
			wService.setCustomer1(cust);
			wService.fundTransfer(wService.getCustomer().getMobileNo(), mobileNo, amount);
			return new ModelAndView("showBalance","customer",wService.getCustomer());
		} catch (CustomerDetailsNotFound | InsufficientBalanceException e ) {
			return new ModelAndView("fundTransfer","errorMessage",e.getMessage());
		}
	}
}

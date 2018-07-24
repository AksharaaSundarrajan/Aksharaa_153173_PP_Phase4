
package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.TransactionRepo;
import com.cg.mypaymentapp.repo.WalletRepo;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService{
	@Autowired(required=true)
	private WalletRepo repo;
	@Autowired(required=true)
	private TransactionRepo tRepo;
	//WalletRepo repo1= new WalletRepoImpl();
	Customer customer;
	Customer customer1;
	Transaction trans;
	public Customer getCustomer1() {
		return customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	Wallet wallet = new Wallet();

	@Override
	public Customer createAccount(Customer customer) {
		return repo.save(customer);
	}
	public Customer showBalance(String mobileNo) {	
		if(repo.findOne(mobileNo)!=null)
			return repo.findOne(mobileNo);
		else throw new InvalidInputException("Invalid mobile number");

	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {	
		customer1 = new Customer(); 
		customer = new Customer(); 
		/*if(sourceMobileNo.equals(targetMobileNo)) {	
			throw new InvalidInputException("Source and target mobile numbers cannot be the same");
		}*/
		customer=repo.findOne(sourceMobileNo);
		customer1 = repo.findOne(targetMobileNo);

		Wallet balance1 = customer.getWallet();
		Wallet balance2 = customer1.getWallet();
		Transaction trans1 = new Transaction();
		if(balance1.getBalance().compareTo(amount)>=0){
			BigDecimal deductedBalance = balance1.getBalance().subtract(amount);
			balance1.setBalance(deductedBalance);
			BigDecimal addedbalance = balance2.getBalance().add(amount);
			balance2.setBalance(addedbalance);
			repo.save(customer);
			repo.save(customer1);
			trans = new Transaction(sourceMobileNo, new Date().toString(), "FUNDS TRANSFERED", "SUCCESS", customer.getWallet().getBalance());
			tRepo.save(trans);
			trans1 = new Transaction(targetMobileNo, new Date().toString(), "FUNDS DEPOSITED", "SUCCESS", customer1.getWallet().getBalance());
			tRepo.save(trans1);
		}
		return customer;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		customer = new Customer(); 
		customer = repo.findOne(mobileNo);
		Wallet wallet = new Wallet();
		wallet = customer.getWallet();
		BigDecimal balanceAfterDeposit = wallet.getBalance().add(amount);
		wallet.setBalance(balanceAfterDeposit);
		repo.save(customer);
		trans = new Transaction(mobileNo, new Date().toString(), "DEPOSIT", "SUCCESS", customer.getWallet().getBalance());
		tRepo.save(trans);
		return customer;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) { 
		customer = new Customer(); 
		customer = repo.findOne(mobileNo);
		Wallet wallet = new Wallet();
		wallet = customer.getWallet();
		if(wallet.getBalance().compareTo(amount)>0 || wallet.getBalance().compareTo(amount)==0) 
		{
			wallet.setBalance(wallet.getBalance().subtract(amount));
			repo.save(customer);
			trans =new Transaction(mobileNo, new Date().toString(), "WITHDRAWAL", "SUCCESS", customer.getWallet().getBalance());
			tRepo.save(trans);
		}
		return customer;
	}

	@Override
	public List<Transaction> getTransactionDetails(String number) {

		return tRepo.findByMobileNo(number);

	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		return repo.findAll();
	}

	@Override
	public List<Customer> filterMinimumBalance() {
		return repo.filterMinimumBalance(new BigDecimal("100"));
	}
}

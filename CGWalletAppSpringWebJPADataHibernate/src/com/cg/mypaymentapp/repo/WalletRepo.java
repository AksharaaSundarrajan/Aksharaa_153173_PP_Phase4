package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, String>{
	@Query("SELECT cust FROM Customer cust WHERE cust.wallet.balance < ?1")
	List<Customer> filterMinimumBalance(BigDecimal minBal);
}

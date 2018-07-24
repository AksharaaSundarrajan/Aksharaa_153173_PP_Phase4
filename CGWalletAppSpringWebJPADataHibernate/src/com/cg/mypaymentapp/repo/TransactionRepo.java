package com.cg.mypaymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mypaymentapp.beans.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,String> {
@Query("SELECT T FROM Transaction T WHERE T.mobileNumber=:mNo")
List<Transaction> findByMobileNo(@Param("mNo")String mobNo);

}

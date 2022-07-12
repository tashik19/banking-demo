package com.midas.banking.repository;

import com.midas.banking.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer> {
    @Query(value= "SELECT t from TransactionDetails t where t.accountNo = :accountNo" )
    List<TransactionDetails> findTransactionsByAccount(@Param("accountNo") int accountNo);
}

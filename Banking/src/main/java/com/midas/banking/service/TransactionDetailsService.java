package com.midas.banking.service;

import com.midas.banking.entity.TransactionDetails;

import java.util.List;

public interface TransactionDetailsService {
    List<TransactionDetails> transactionHistory(TransactionDetails transactionDetails);
}

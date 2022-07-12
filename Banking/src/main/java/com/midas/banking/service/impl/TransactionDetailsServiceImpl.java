package com.midas.banking.service.impl;

import com.midas.banking.entity.TransactionDetails;
import com.midas.banking.repository.TransactionDetailsRepository;
import com.midas.banking.service.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public List<TransactionDetails> transactionHistory(TransactionDetails transactionDetails) {
        List<TransactionDetails> list = transactionDetailsRepository.findTransactionsByAccount(transactionDetails.getAccountNo());
        return list;
    }
}

package com.midas.banking.service.impl;

import com.midas.banking.dto.BalanceTransfer;
import com.midas.banking.entity.AccountDetails;
import com.midas.banking.entity.TransactionDetails;
import com.midas.banking.repository.AccountDetailsRepository;
import com.midas.banking.repository.TransactionDetailsRepository;
import com.midas.banking.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

    int MAX_VALUE = 999999; //Random Number Max Value
    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public AccountDetails getAccountDetails(int accountNo) {
        AccountDetails account = accountDetailsRepository.findById(accountNo).get();
        return account;
    }

    @Override
    public BalanceTransfer balanceTransfer(BalanceTransfer balanceTransfer) {
        AccountDetails fromAccount = accountDetailsRepository.findById(balanceTransfer.getFromAccount()).get();
        fromAccount.setAvailableBalance(fromAccount.getAvailableBalance()-balanceTransfer.getAmount());
        accountDetailsRepository.save(fromAccount);

        AccountDetails toAccount = accountDetailsRepository.findById((balanceTransfer.getToAccount())).get();
        toAccount.setAvailableBalance(toAccount.getAvailableBalance() + balanceTransfer.getAmount());
        accountDetailsRepository.save(toAccount);

        Random random = new Random();
        int referenceNumber = random.nextInt(MAX_VALUE);

        TransactionDetails transactionDetails1 = new TransactionDetails();
        transactionDetails1.setAccountNo(balanceTransfer.getToAccount());
        transactionDetails1.setTransactionFlag("D");
        transactionDetails1.setTransactionAmount(balanceTransfer.getAmount());
        transactionDetails1.setReferenceNo(referenceNumber);
        transactionDetailsRepository.save(transactionDetails1);

        TransactionDetails transactionDetails2 = new TransactionDetails();
        transactionDetails2.setAccountNo(balanceTransfer.getFromAccount());
        transactionDetails2.setTransactionFlag("C");
        transactionDetails2.setTransactionAmount(balanceTransfer.getAmount());
        transactionDetails2.setReferenceNo(referenceNumber);
        transactionDetailsRepository.save(transactionDetails2);

        BalanceTransfer model = new BalanceTransfer();
        model.setAccountBalance(toAccount.getAvailableBalance());
        model.setReferenceNo(referenceNumber);
        return model;
    }
}

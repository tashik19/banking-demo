package com.midas.banking.service;

import com.midas.banking.dto.BalanceTransfer;
import com.midas.banking.entity.AccountDetails;
import com.midas.banking.entity.TransactionDetails;

public interface AccountDetailsService {
    AccountDetails getAccountDetails(int accountNo);

    BalanceTransfer balanceTransfer(BalanceTransfer balanceTransfer);
}

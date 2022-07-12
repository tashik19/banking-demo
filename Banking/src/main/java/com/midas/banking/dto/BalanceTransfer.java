package com.midas.banking.dto;

import lombok.Data;

@Data
public class BalanceTransfer {
    private double accountBalance;
    private int referenceNo;
    private int fromAccount;
    private int toAccount;
    private double amount;
}

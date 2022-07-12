package com.midas.banking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "account_details")

public class AccountDetails {
    @Id
    @Column(name = "account_no")
    private int accountNo;

    @Column(name = "available_balance")
    private double availableBalance;

}

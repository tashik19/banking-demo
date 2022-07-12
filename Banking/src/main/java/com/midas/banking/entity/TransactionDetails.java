package com.midas.banking.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_details")
public class TransactionDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "account_no")
    private int accountNo;

    @Column(name = "transaction_flag")
    private String transactionFlag;

    @Column(name = "reference_no")
    private int referenceNo;

    @Column(name = "transaction_amount")
    private Double transactionAmount;

}
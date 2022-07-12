package com.midas.banking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user_details")
public class UserDetails {
    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name = "account_no")
    private int accountNo;

    @Column(name = "password")
    private String password;
}

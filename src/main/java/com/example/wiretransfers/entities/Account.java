package com.example.wiretransfers.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")

public class Account {

    @Id
    @GeneratedValue
    @Column(name = "accountNumber", nullable = false)
    private Long accountNumber;

    @Column(name = "balance", nullable = false)
    private int balance;

    @Column(name = "ownerId", nullable = false)
    private Long ownerId;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setBalance(Long ownerId) {
        this.ownerId = ownerId;
    }

}

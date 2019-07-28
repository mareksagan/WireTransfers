package com.example.wiretransfers.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNT")

public class Account {

    @Id
    @GeneratedValue
    @Column(name = "accountNumber", nullable = false)
    @Size(min = 6)
    private int accountNumber;

    @Column(name = "balance", nullable = false)
    private int balance;

    @Column(name = "ownerId", nullable = false)
    private UUID ownerId;

    public Account() {}

    public Account(int number) {
        this.accountNumber = number;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Account setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Account setOwnerId(String ownerId) {
        this.ownerId = UUID.fromString(ownerId);
        return this;
    }

}

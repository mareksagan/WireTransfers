package com.example.wiretransfers.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNT")

public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "accountNumber", nullable = false)
    private int accountNumber;

    @Column(name = "balance", nullable = false)
    private int balance = 0;

    @Column(name = "ownerId", nullable = false)
    private UUID ownerId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "senderAccountNumber")
    private Set<Transaction> outgoingTransfers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receiverAccountNumber")
    private Set<Transaction> incomingTransfers = new HashSet<>();

    @ManyToOne
    private Customer customer;

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

    public Set<Transaction> getOutgoingTransfers() {
        return outgoingTransfers;
    }

    public Set<Transaction> getIncomingTransfers() {
        return incomingTransfers;
    }

}

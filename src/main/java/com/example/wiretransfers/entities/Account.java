package com.example.wiretransfers.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "accountNumber", nullable = false)
    private int accountNumber;

    @Column(name = "balance", nullable = false)
    private int balance = 0;

    @Column(name = "isActive", nullable = false)
    private boolean isActive = true;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "senderAccount")
    private List<Transaction> sentTransfers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receiverAccount")
    private List<Transaction> receivedTransfers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Account() {}

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    protected Account setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public UUID getOwnerId() {
        return customer.getCustomerId();
    }

    protected List<Transaction> getSentTransfers() {
        return sentTransfers;
    }

    protected List<Transaction> getReceivedTransfers() {
        return receivedTransfers;
    }

    public List<Transaction> getReadonlySentTransfers() {
        return Collections.unmodifiableList(sentTransfers);
    }

    public List<Transaction> getReadonlyReceivedTransfers() {
        return Collections.unmodifiableList(receivedTransfers);
    }

    public Transaction sendMoney(int amount, Account to) {
        var transfer = new Transaction().setSenderAccount(this).setReceiverAccount(to).setAmount(amount).commit();
        return transfer;
    }

    public Account deactivate() {
        this.isActive = false;
        return this;
    }

}

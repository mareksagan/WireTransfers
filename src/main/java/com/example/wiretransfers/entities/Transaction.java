package com.example.wiretransfers.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTION")

public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transactionId", nullable = false)
    private UUID transactionId;

    @Column(name = "senderAccountNumber", nullable = false)
    private int senderAccountNumber;

    @Column(name = "receiverAccountNumber", nullable = false)
    private int receiverAccountNumber;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "commited", nullable = false)
    private boolean commited = false;

    @Column(name = "timestamp", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date timestamp;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Account senderAccount = new Account();

    public Transaction(int from, int to, int amount) {
        this.senderAccountNumber = from;
        this.receiverAccountNumber = to;
        this.amount = amount;
    }

    public Transaction(String id, int from, int to, int amount) {
        this.transactionId = UUID.fromString(id);
        this.senderAccountNumber = from;
        this.receiverAccountNumber = to;
        this.amount = amount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public int getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public int getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public Transaction commit() {
        if (amount <= senderAccount.getBalance()) commited = true;
        return this;
    }

}

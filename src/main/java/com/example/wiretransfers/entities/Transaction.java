package com.example.wiretransfers.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionId", nullable = false)
    private UUID transactionId;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "commited", nullable = false)
    private boolean commited = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sentTransfers")
    private Account senderAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receivedTransfers")
    private Account receiverAccount;

    public Transaction() {}

    public UUID getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public Transaction setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getSenderAccount() {
        return senderAccount.getAccountNumber();
    }

    public Transaction setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
        return this;
    }

    public int getReceiverAccount() {
        return receiverAccount.getAccountNumber();
    }

    public Transaction setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
        return this;
    }

    public Transaction commit() {
        if (amount <= senderAccount.getBalance()) {
            var receiverBalance = receiverAccount.getBalance();
            var senderBalance = senderAccount.getBalance();

            senderAccount.setBalance(senderBalance - amount);
            receiverAccount.setBalance(receiverBalance + amount);

            senderAccount.getSentTransfers().add(this);
            receiverAccount.getReceivedTransfers().add(this);

            commited = true;
        }
        return this;
    }

}

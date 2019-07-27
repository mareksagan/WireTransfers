package com.example.wiretransfers.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")

public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transactionId", nullable = false)
    private Long transactionId;

    @Column(name = "senderAccountNumber", nullable = false)
    private String firstName;

    @Column(name = "receiverAccountNumber", nullable = false)
    private String lastName;

    @Column(name = "timestamp", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date timestamp;
}

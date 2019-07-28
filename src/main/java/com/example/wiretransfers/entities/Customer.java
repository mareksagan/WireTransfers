package com.example.wiretransfers.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER")

public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customerId", nullable = false)
    private UUID customerId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<Account>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<Transaction>();

    public Customer() {}

    public Customer(String id) {
        this.customerId = UUID.fromString(id);
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

}

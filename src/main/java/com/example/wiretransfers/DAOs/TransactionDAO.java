package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Customer;
import com.example.wiretransfers.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, UUID> {

    public Transaction findByTransactionId(UUID transactionId);

    public List<Transaction> findAllByCommitedIsTrue();

    public List<Transaction> findAllByCommitedIsFalse();

}

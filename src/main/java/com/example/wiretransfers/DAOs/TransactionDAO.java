package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Customer;
import com.example.wiretransfers.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, UUID> {

    public Transaction findByTransactionId(String transactionId);

    public List<Transaction> findByReceiverAccountNumber(int number);

    public List<Transaction> findBySenderAccountNumber(int number);

    public List<Transaction> findBySenderAccountNumberAndReceiverAccountNumber(int sender, int receiver);

    public List<Transaction> findByTimestampBetween(Date start, Date end);

}

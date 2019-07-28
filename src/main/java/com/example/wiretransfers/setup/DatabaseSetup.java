package com.example.wiretransfers.setup;

import com.example.wiretransfers.DAOs.AccountDAO;
import com.example.wiretransfers.DAOs.CustomerDAO;
import com.example.wiretransfers.DAOs.TransactionDAO;
import com.example.wiretransfers.entities.Account;
import com.example.wiretransfers.entities.Customer;
import com.example.wiretransfers.entities.Transaction;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class DatabaseSetup implements ApplicationRunner {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addCustomers();
        addAccounts();
        addTransactions();
    }

    private void addCustomers() {
        var newCustomer1 = new Customer("1d9c2e43-201c-41fa-82e2-b95b657d117f")
                .setFirstName("Alexandra").setLastName("Ungureanu");
        var newCustomer2 = new Customer("5bb07c9c-e2d3-4f82-9a78-9d8dca4688e8")
                .setFirstName("Oana").setLastName("Nistor");
        var newCustomer3 = new Customer("44633a93-7fb2-4711-9a7b-70a18cb9114d")
                .setFirstName("Marius").setLastName("Nedelcu");

        customerDAO.save(newCustomer1);
        customerDAO.save(newCustomer2);
        customerDAO.save(newCustomer3);
    }

    private void addAccounts() {
        var newAccount1 = new Account(1)
                .setOwnerId("1d9c2e43-201c-41fa-82e2-b95b657d117f")
                .setBalance(20);

        var newAccount2 = new Account(2)
                .setOwnerId("5bb07c9c-e2d3-4f82-9a78-9d8dca4688e8")
                .setBalance(0);

        accountDAO.save(newAccount1);
        accountDAO.save(newAccount2);
    }

    private void addTransactions() {
        var newTransaction1 = new Transaction(1,2,5);

        transactionDAO.save(newTransaction1);
    }
}

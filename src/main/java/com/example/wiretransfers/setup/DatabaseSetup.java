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

@Component
public class DatabaseSetup implements ApplicationRunner {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addCustomers();
    }

    private void addCustomers() {
        var newCustomer1 = new Customer().setFirstName("Marius").setLastName("Nedelcu");
        var newCustomer2 = new Customer().setFirstName("Alexandra").setLastName("Ungureanu");

        var newAccount1 = new Account(20);
        var newAccount2 = new Account();

        newCustomer1.addAccount(newAccount1);
        newCustomer2.addAccount(newAccount2);

        customerDAO.save(newCustomer1);
        customerDAO.save(newCustomer2);
        newAccount1.sendMoney(5, newAccount2);

        accountDAO.save(newAccount1);
    }

}

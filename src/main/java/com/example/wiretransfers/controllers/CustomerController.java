package com.example.wiretransfers.controllers;

import com.example.wiretransfers.DAOs.CustomerDAO;
import com.example.wiretransfers.entities.Account;
import com.example.wiretransfers.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @ResponseBody
    @RequestMapping("/")
    public List<Transaction> index() {

        List<Transaction> userTransactions = new ArrayList<>();

        customerDAO.findByCustomerId("5bb07c9c-e2d3-4f82-9a78-9d8dca4688e8").get(0).getAccounts()
                .forEach(a -> userTransactions.addAll(a.getIncomingTransfers()));

        return userTransactions;
    }

}

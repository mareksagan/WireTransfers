package com.example.wiretransfers.controllers;

import com.example.wiretransfers.DAOs.AccountDAO;
import com.example.wiretransfers.DAOs.CustomerDAO;
import com.example.wiretransfers.entities.Account;
import com.example.wiretransfers.entities.Customer;
import com.example.wiretransfers.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AccountDAO accountDAO;

    @ResponseBody
    @RequestMapping("/")
    public Customer index() {

        var customer = customerDAO.findByFirstNameAndLastName("Marius", "Nedelcu").get(0);

        return customer;
    }

}

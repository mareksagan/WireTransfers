package com.example.wiretransfers.controllers;

import com.example.wiretransfers.DAOs.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        var lastName = customerDAO.findByFirstName("Marius").get(0).getLastName();

        return lastName;
    }

}

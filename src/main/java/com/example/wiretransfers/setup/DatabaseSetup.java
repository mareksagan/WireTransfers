package com.example.wiretransfers.setup;

import com.example.wiretransfers.DAOs.CustomerDAO;
import com.example.wiretransfers.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class DatabaseSetup implements ApplicationRunner {

    private CustomerDAO customerDAO;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DatabaseSetup(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var newCustomer = new Customer();

        newCustomer.setFirstName("Marius");
        newCustomer.setLastName("Ungureanu");

        customerDAO.save(newCustomer);
    }
}

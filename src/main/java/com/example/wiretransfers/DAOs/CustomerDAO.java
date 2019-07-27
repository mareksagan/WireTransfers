package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {

    public List<Customer> findByCustomerId(Long customerId);

    public List<Customer> findByFirstName(String firstName);

}

package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, UUID> {

    public Customer findByCustomerId(UUID customerId);

    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}

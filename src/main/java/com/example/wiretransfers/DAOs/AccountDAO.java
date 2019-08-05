package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

    public Account findByAccountNumber(int accountNumber);
}

package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends CrudRepository<Account, Integer> {

    public Account findByAccountNumber(int accountNumber);

    public List<Account> findByOwnerId(String ownerId);
}

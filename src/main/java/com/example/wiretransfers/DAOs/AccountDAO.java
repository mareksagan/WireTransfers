package com.example.wiretransfers.DAOs;

import com.example.wiretransfers.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends CrudRepository<Account, Long> {

    public Account findByAccountNumber(Long accountNumber);

    public List<Account> findByOwnerId(String ownerId);
}

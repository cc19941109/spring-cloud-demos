package com.chen.springbootjparedisdemo.service.impl;

import com.chen.springbootjparedisdemo.entity.Account;
import com.chen.springbootjparedisdemo.repository.AccountReposiory;
import com.chen.springbootjparedisdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "account")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountReposiory accountReposiory;


    @Override
    @Cacheable(value = "accountInfo", key = "#p0")
    public Account findById(Long id) {

        Account one = accountReposiory.findOne(id);
        return one;
    }

    @Override
    public Account deleteById(Long id) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    @CachePut(value = "accountInfo", key = "#p0")
    public Account updateMoney(Long id, Double money) {
        Account account = findById(id);
        if (account == null) {
            return null;
        }
        if (account.getMoney().equals(money)) {
            return account;
        }
        account.setMoney(money);
        Account save = accountReposiory.save(account);
        return save;
    }
}

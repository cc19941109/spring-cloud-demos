package com.chen.springbootjparedisdemo.service;

import com.chen.springbootjparedisdemo.entity.Account;

public interface AccountService {

    Account findById(Long id);

    Account deleteById(Long id);

    Account updateAccount(Account account);

    Account updateMoney(Long id, Double money);

}

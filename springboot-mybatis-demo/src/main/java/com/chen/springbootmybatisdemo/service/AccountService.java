package com.chen.springbootmybatisdemo.service;

import com.chen.springbootmybatisdemo.domain.Account;

import java.util.List;

public interface AccountService {


    Integer add(String name, Double money);

    Integer update(String name, Double money, Long id);

    Integer delete(Long id);

    Account findAccount(Long id);

    List<Account> findAccountList();
}

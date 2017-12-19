package com.chen.springbootmybatisdemo.service.impl;

import com.chen.springbootmybatisdemo.dao.AccountMapper;
import com.chen.springbootmybatisdemo.domain.Account;
import com.chen.springbootmybatisdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public Integer add(String name, Double money) {
        return accountMapper.add(name,money);
    }

    @Override
    public Integer update(String name, Double money, Long id) {
        return accountMapper.update(name,money,id);

    }

    @Override
    public Integer delete(Long id) {
        return accountMapper.delete(id);
    }

    @Override
    public Account findAccount(Long id) {
        return accountMapper.findAccount(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}

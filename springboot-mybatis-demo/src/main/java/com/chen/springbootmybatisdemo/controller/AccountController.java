package com.chen.springbootmybatisdemo.controller;

import com.chen.springbootmybatisdemo.domain.Account;
import com.chen.springbootmybatisdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") Long id) {

        return accountService.findAccount(id);
    }

    @GetMapping("/list")
    public List<Account> getAllAccount(){

        return  accountService.findAccountList();
    }
}

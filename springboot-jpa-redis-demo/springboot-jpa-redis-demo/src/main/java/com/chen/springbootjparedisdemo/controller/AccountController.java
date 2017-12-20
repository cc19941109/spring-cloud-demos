package com.chen.springbootjparedisdemo.controller;

import com.chen.springbootjparedisdemo.entity.Account;
import com.chen.springbootjparedisdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Long id){
        return accountService.findById(id);
    }

    @PostMapping("/update")
    public Account update(@RequestParam(value = "id")Long id,@RequestParam(value = "money")Double money){
        Account account = accountService.updateMoney(id, money);
        return account;
    }

}

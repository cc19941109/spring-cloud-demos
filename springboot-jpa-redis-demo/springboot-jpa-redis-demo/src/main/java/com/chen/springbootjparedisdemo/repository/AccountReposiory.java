package com.chen.springbootjparedisdemo.repository;

import com.chen.springbootjparedisdemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountReposiory extends JpaRepository<Account,Long> {
}

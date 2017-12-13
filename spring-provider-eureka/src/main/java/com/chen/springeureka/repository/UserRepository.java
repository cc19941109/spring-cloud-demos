package com.chen.springeureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chen.springeureka.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

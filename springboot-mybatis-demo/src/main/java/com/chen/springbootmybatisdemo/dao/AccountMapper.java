package com.chen.springbootmybatisdemo.dao;

import com.chen.springbootmybatisdemo.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    Integer add(@Param("name") String name, @Param("money") Double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    Integer update(@Param("name") String name, @Param("money") Double money, @Param("id") Long id);

    @Delete("delete from account where id = #{id}")
    Integer delete(Long id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Account findAccount(@Param("id") Long id);

    @Select("select id, name as name, money as money from account")
    List<Account> findAccountList();
}
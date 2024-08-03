package com.crudspringboot.main.Repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspringboot.main.Models.User;


public interface IUserRepo extends JpaRepository<User,BigInteger>{
     User findByUsername(String username);
}

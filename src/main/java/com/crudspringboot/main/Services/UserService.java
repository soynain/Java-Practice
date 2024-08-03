package com.crudspringboot.main.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringboot.main.Models.User;
import com.crudspringboot.main.Repositories.IUserRepo;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    public User findUserByEmail(String email){
        return userRepo.findByUsername(email);
    }
}

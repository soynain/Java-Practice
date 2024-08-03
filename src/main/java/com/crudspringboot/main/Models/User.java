package com.crudspringboot.main.Models;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name="mail",length = 80,nullable = false)
    private String mail;

    @Column(name="pass",nullable = false)
    private String password;

    @Column(name="user",nullable=false)
    private String username;

}

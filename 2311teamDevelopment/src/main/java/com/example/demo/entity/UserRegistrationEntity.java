package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class UserRegistrationEntity {

@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="name")
private String name;

@Column(name="kana")
private String kana;

@Column(name="email")
private String email;

@Column(name="password")
private String password;
}
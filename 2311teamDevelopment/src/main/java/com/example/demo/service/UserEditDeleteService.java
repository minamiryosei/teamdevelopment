package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEditDeleteEntity;
import com.example.demo.repository.UserEditDeleteRepository;


@Service
@Transactional(rollbackOn=Exception.class)
public class UserEditDeleteService {

 @Autowired
 private UserEditDeleteRepository userEditDeleteRepository;

 public List<UserEditDeleteEntity> searchAll() {
  return userEditDeleteRepository.findAll();
 }




}
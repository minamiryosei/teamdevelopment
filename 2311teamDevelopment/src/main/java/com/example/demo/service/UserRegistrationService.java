package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.repository.UserRegistrationRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class UserRegistrationService {

 @Autowired
 private UserRegistrationRepository userRegistrationRepository;

 public List<UserRegistrationEntity> searchAll() {
  return userRegistrationRepository.findAll();
 }

public void create(UserRegistrationRequest userRegistrationRequest) {
	UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
	userRegistrationEntity.setName(userRegistrationRequest.getName());
	userRegistrationEntity.setKana(userRegistrationRequest.getKana());
	userRegistrationEntity.setEmail(userRegistrationRequest.getEmail());
	userRegistrationEntity.setPassword(userRegistrationRequest.getPassword());

 }




}
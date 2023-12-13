package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.repository.UserRegistrationRepository;

@Service
@Transactional(dontRollbackOn=Exception.class)
public class UserRegistrationService {

 @Autowired
 private UserRegistrationRepository userRegistrationRepository;

 public List<UserRegistrationEntity> searchAll() {
	 return userRegistrationRepository.findAll();
 }



public void create(UserRegistrationRequest userRegistrationRequest) {
	UserRegistrationEntity userRegistration = new UserRegistrationEntity();
	userRegistration.setName(userRegistrationRequest.getName());
	userRegistration.setKana(userRegistrationRequest.getKana());
	userRegistration.setEmail(userRegistrationRequest.getEmail());
	userRegistration.setPassword(userRegistrationRequest.getPassword());
	userRegistrationRepository.save(userRegistration);

 }




}
package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

 public UserRegistrationEntity findById(Long id) {
	 return userRegistrationRepository.findById(id).get();
 }

 //public void update(UserEditDeleteRequest userEditDeleteRequest)// {
	 //UserRegistrationEntity userRegistrationEntity = findById(userEditDeleteRequest.getId());//
	// userRegistrationEntity.setName(userEditDeleteRequest.getName());//

 }




//}//
package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserEditDeleteRequest;
import com.example.demo.entity.UserEditDeleteEntity;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.repository.UserEditDeleteRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class UserEditDeleteService {

 @Autowired
 private UserEditDeleteRepository userEditDeleteRepository;


 public UserRegistrationEntity findById(Integer id) {
	 return userEditDeleteRepository.findById(id).get();
 }



public void update(UserEditDeleteRequest userEditDeleteRequest) {
	UserEditDeleteEntity userEditDelete = new UserEditDeleteEntity();
	userEditDelete.setName(userEditDeleteRequest.getName());
	userEditDelete.setKana(userEditDeleteRequest.getKana());
	userEditDelete.setEmail(userEditDeleteRequest.getEmail());
	userEditDelete.setPassword(userEditDeleteRequest.getPassword());
	userEditDeleteRepository.save(userEditDelete);

 }




}
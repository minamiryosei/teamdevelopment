package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserEditDeleteRequest;

import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.repository.UserEditDeleteRepository;

@Service
public class UserEditDeleteService {

	@Autowired
	private UserEditDeleteRepository userEditDeleteRepository;

	public List<UserRegistrationEntity> searchAll() {
		return userEditDeleteRepository.findAll();
	}

	public UserRegistrationEntity findById(Integer id) {
		return userEditDeleteRepository.findById(id).get();
	}

	public void update(UserEditDeleteRequest userEditDeleteRequest) {
		UserRegistrationEntity userRegistrationEntity = findById(userEditDeleteRequest.getId());
		userRegistrationEntity.setName(userEditDeleteRequest.getName());
		userRegistrationEntity.setKana(userEditDeleteRequest.getKana());
		userRegistrationEntity.setEmail(userEditDeleteRequest.getEmail());
		userRegistrationEntity.setPassword(userEditDeleteRequest.getPassword());
		userEditDeleteRepository.save(userRegistrationEntity);
	}
}
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserEditDeleteRequest;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.repository.UserEditDeleteRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserEditDeleteService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserEditDeleteRepository userEditDeleteRepository;

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserRegistrationEntity findById(Integer id) {
		return userEditDeleteRepository.getOne(id);
	}

	/**
	 * ユーザー情報 更新
	 * @param user ユーザー情報
	 */
	public void update(UserEditDeleteRequest userEditDeleteRequest) {
		UserRegistrationEntity userRegistrationEntity = findById(userEditDeleteRequest.getId());
		userRegistrationEntity.setName(userEditDeleteRequest.getName());
		userRegistrationEntity.setKana(userEditDeleteRequest.getKana());
		userRegistrationEntity.setEmail(userEditDeleteRequest.getEmail());
		userRegistrationEntity.setPassword(userEditDeleteRequest.getPassword());
		userEditDeleteRepository.save(userRegistrationEntity);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		UserRegistrationEntity userRegistrationEntity = findById(id);
		userEditDeleteRepository.delete(userRegistrationEntity);
	}
}
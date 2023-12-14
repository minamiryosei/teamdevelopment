package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserRegistrationEntity;

@Repository
public interface UserEditDeleteRepository extends JpaRepository<UserRegistrationEntity, Integer> {

}
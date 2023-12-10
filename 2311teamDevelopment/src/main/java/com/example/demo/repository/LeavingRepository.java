package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LeavingEntity;

/**
 * ユーザー情報 Repository
 */
public interface LeavingRepository extends JpaRepository<LeavingEntity, Integer> {}
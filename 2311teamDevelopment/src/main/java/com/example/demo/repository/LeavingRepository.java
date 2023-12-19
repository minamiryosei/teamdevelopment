package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LeavingEntity;

@Repository
/**
 * ユーザー情報 Repository
 */
public interface LeavingRepository extends JpaRepository<LeavingEntity, Integer> {}
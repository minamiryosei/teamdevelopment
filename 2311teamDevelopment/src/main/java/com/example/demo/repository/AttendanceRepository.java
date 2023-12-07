package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AttendanceEntity;

/**
 * ユーザー情報 Repository
 */
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {}
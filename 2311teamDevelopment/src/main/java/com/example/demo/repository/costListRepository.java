package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.costListEntity;

@Repository
public interface costListRepository extends JpaRepository<costListEntity, Long> {}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.costListEntity;
import com.example.demo.repository.costListRepository;

@Service
public class costListService {
	
@Autowired
private costListRepository costlistRepository;

public List<costListEntity> searchAll() {
	return costlistRepository.findAll();
  }
}

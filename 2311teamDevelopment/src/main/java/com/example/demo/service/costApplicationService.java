package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.costApplicationRequest;
import com.example.demo.entity.costApplicationEntity;
import com.example.demo.repository.costApplicationRepository;

@Service
@Transactional (rollbackFor = Exception.class)
public class costApplicationService {
	
@Autowired
private costApplicationRepository costapplicationRepository;


public List<costApplicationEntity> searchAll() {
	return costapplicationRepository.findAll();
}


public void create(costApplicationRequest costapplicationRequest) {
	 try {
	      String str = "2020/01/01 12:00:00";
	      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = format.parse(str);
	    } 
	 catch (ParseException e) {
	      e.printStackTrace();
	    }
	 
	costApplicationEntity costapplication = new costApplicationEntity();
	costapplication.setUser_id(costapplicationRequest.getUser_id());
	costapplication.setApplication_day(costapplicationRequest.getApplication_day());
	costapplication.setCategory(costapplicationRequest.getCategory());
	costapplication.setCost(costapplicationRequest.getCost());
	costapplication.setComments(costapplicationRequest.getComments());
	costapplicationRepository.save(costapplication);
	
    } 
  }

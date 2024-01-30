package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.service.UserRegistrationService;

@WebMvcTest(UserRegistrationController.class)
class UserRegistrationControllerTest {

	@MockBean
	UserRegistrationService userRegistrationService;

	@Autowired
	private UserRegistrationController userfRegistrationController;

	private MockMvc mockMvc;

	/**
	* セットアップメソッド
	*/
	@BeforeEach
	public void setup() {
		mockMvc =  MockMvcBuilders.standaloneSetup(userfRegistrationController).build();
	}

	@Test
	public void test() throws Exception{
		mockMvc.perform(get("/UserRegistration"))
		.andExpect(status().isOk());
	}

}

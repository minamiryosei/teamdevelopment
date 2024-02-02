package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.service.UserRegistrationService;

@WebMvcTest(UserRegistrationController.class)
class UserRegistrationControllerTest {

	@MockBean
	UserRegistrationService userRegistrationService;

	@Autowired
	private MockMvc mockMvc;

	/**
	* セットアップメソッド
	*/
//	@BeforeEach
//	public void setup() {
//		mockMvc =  MockMvcBuilders.standaloneSetup(userfRegistrationController).build();
//	}


	@Test
	public void GetTest() throws Exception{
		mockMvc.perform(get("/UserRegistration"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("userRegistrationRequest"))
		.andExpect(view().name("UserRegistration"));
	}

	/**
	 * テストメソッド create()
	 * @throws Exception
	 */
	@DisplayName("【正常系】登録処理")
	@Test
	public void PostTest() throws Exception{
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setName("yuta");
		request.setEmail("sample@java");
		request.setKana("カナ");
		request.setPassword("password");

		mockMvc.perform(post("/UserRegistration/create").flashAttr("userRegistrationRequest", request))
		.andExpect(model().hasNoErrors())
		.andExpect(model().attribute("userRegistrationRequest", request))
		.andExpect(view().name("myPage"));
	}

}

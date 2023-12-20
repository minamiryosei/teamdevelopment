package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class UserRegistrationRequest implements Serializable {

	@NotEmpty(message="名前を入力してください")
	private String name;

	@NotEmpty(message="フリガナを入力してください")
	private String kana;

	@NotEmpty(message="メールアドレスを入力してください")
	private String email;

	@NotEmpty(message="パスワードを入力してください")
	private String password;
}
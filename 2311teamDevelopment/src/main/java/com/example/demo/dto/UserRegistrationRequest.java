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
	@Email(message="メールアドレスの形式で入力してください")
	private String email;

	@NotEmpty(message="パスワードを入力してください")
	@Length(min= 8, message="パスワードは8桁以上で入力してください")
	@Pattern(regexp= "^[a-zA-Z0-9]+$", message="パスワードは半角英数字で入力してください")
	private String password;
}
package com.hcl.taskmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String role;
	private String password;
	private String email;
	private String firstname;
	private String lastname;

	public void setPwd(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		this.password = bCryptPasswordEncoder.encode(password);
	}

}

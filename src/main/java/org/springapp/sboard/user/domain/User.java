package org.springapp.sboard.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * 시큐리티와 일관성을 위해 변경.
	 * 우리나라(한국)은 userid가 일반적이지만
	 * security를 만든곳 에서는 username이 일반적인듯.
	 * 로마에 왔으니 일단 로마법대로..
	 */
	//
	private String username;
	
	@Column(nullable = false) private String name;
	
	@Column(unique = true) private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}

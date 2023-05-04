package com.donatopedro.workshopmongo.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users_banned")
public class UserBan implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id_user;
	private String email_user;

	public UserBan() {
	}

	public UserBan(User user) {
		this.email_user = user.getEmail();
		this.id_user = user.getId();
	}

	public String getId_user() {
		return id_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

}

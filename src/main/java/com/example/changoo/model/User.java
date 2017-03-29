package com.example.changoo.model;

public class User {
	String id;
	String password;
	String name;
	String gender;
	String birth;
	String phonenumber;

	public User() {
		super();
	}

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public User(String id, String password, String name, String gender, String birth, String phonenumber) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}

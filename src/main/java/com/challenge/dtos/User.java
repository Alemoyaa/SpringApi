package com.application.dtos;

import com.application.common.CommonEntity;

public class User extends CommonEntity{
	
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	
	private Company company;
	private Address address;
	
	public User() {
		super();
	}
	
	public User(String name, String username, String email, String phone, String website, Company company,
			Address address) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.company = company;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}

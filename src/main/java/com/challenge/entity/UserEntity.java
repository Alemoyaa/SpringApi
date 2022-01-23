package com.application.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 2662137524246716715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;

	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<PermitsEntity> permisos = new ArrayList<PermitsEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<PermitsEntity> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermitsEntity> permisos) {
		this.permisos = permisos;
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

	
}

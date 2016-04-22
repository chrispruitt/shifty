package com.pru.shifty.api.model;

import com.pru.shifty.api.util.Role;

public class User {

	private long id;
	private String name;
	private String username;
	private Role role;

	public User(){
		id=0;
	}
	
	public User(long id, String name, String username, Role role){
		this.id = id;
		this.name = name;
		this.username = username;
		this.role = role;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

package com.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private Long rId;

	private String roleName;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy="roles")
	@JsonIgnore
	private Set<User> users;

	public Role() {
		super();
	}

	public Role(Long rId, String roleName, Set<User> users) {
		super();
		this.rId = rId;
		this.roleName = roleName;
		this.users = users;
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	 
	
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_authorities"
	,joinColumns=@JoinColumn(name="user_id"),
	 inverseJoinColumns =@JoinColumn(name="Authority_id"))
	
	private Set<Authority>authorites; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
 
	}
	
	public Set<Authority> getAuthorites() {
		return authorites;
	}
	public void setAuthorites(Set<Authority> authorites) {
		this.authorites = authorites;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", password=" + password  
				+ "]";
	}
	
	
	

}

package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	
	@Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@Column(name = "ID")
	private Long id;
	
	
	private String name;
	private long followers;
	
	public User() {
		
	}
	
	public User(String name, long followers) {
		this.name = name;
		this.followers = followers;
	}

	@Override
	public String toString() {
		return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
	}

}

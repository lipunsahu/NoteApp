package com.lipun.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	private int id;
	
	private String name;
	
	private int age;
	
	private long mobile;
	
	private String email;
	
	private String password;
	
	@ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Note> notes;
}

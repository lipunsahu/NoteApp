package com.lipun.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Note {

	@Id
	private int id;
	
	private String title;
	
	private String description;
	
	@ManyToOne
	@JoinColumn
	private User user;
}

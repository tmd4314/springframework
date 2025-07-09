package com.yedam.app.jpa.service;

import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "TBL_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;
	@Column(name="username", length=20, nullable=false, unique=true)
	private String id;
	private String password;
	private Integer age;
	
	@CreationTimestamp
	private Timestamp joinDate;
}

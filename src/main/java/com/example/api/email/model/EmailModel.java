package com.example.api.email.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="email_model")
public class EmailModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="to_email")
	private String toEmail;
	
	@Column(name="body")
	private String body;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="attachment")
	private String attachment; 
}

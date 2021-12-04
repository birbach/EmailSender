package com.example.api.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

	private String toEmail;
	private String body;
	private String subject;
	private String attachment; 
}

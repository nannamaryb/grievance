package com.pg.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LogData {

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please enter a valid email")
	@NotBlank(message = "Email cannot be empty")
	private String email;

	@Override
	public String toString() {
		return "LogData [email=" + email + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}  
}
            
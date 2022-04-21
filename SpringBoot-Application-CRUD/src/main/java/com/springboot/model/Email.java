package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email_dtls")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int EId;
	private String emailId;

	@ManyToOne
	@JoinColumn(name = "ID")
	Student std;

	public int getId() {
		return EId;
	}

	public void setId(int id) {
		this.EId = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Email(int id, String emailId, Student std) {
		this.EId = id;
		this.emailId = emailId;
		this.std = std;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
}

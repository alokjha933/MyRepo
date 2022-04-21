package com.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Email> email_Dtls;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Student() {
	}

	public Student(String sName, List<Email> email_Dtls) {
		this.sName = sName;
		this.email_Dtls = email_Dtls;
	}

	public List<Email> getEmail_Dtls() {
		return email_Dtls;
	}

	public void setEmail_Dtls(List<Email> email_Dtls) {
		this.email_Dtls = email_Dtls;
	}

}

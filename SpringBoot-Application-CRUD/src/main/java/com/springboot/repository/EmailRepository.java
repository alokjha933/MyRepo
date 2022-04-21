package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Email;
import com.springboot.model.Student;

public interface EmailRepository extends JpaRepository<Email, Long> {

}

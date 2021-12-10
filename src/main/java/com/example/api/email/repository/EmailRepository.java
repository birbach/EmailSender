package com.example.api.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.email.model.SimpleEmailModel;

public interface EmailRepository extends JpaRepository<SimpleEmailModel, Long>{

}

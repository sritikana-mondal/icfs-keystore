package com.cts.key.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.key.model.KeyDetails;


public interface KeyRepository extends JpaRepository<KeyDetails,String> {
	
	public Optional<KeyDetails> findByKid(String kid);
}

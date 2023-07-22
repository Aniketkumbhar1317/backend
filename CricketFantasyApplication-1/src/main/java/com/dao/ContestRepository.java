package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Contest;

public interface ContestRepository extends JpaRepository<Contest, Long> {

	Contest findByName(String name);
}

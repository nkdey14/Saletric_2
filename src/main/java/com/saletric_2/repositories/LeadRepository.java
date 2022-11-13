package com.saletric_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saletric_2.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

}

package com.saletric_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saletric_2.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer> {

}

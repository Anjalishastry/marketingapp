package com.marketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entities.lead;

public interface LeadRepository extends JpaRepository<lead,Long> {
}

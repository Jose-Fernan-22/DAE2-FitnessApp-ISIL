package com.FitnessAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FitnessAppSpring.entity.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
	
	
}

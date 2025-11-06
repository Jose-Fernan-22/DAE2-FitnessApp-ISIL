package com.FitnessAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessAppSpring.entity.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    // Aquí puedes agregar consultas personalizadas si deseas buscar por usuario o plan más adelante
}

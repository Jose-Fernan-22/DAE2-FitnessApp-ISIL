package com.FitnessAppSpring.repository;

import com.FitnessAppSpring.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    // 🟢 Buscar planes por categoría (opcional)
    List<Plan> findByCategoria(String categoria);

    // 🟢 Buscar planes por nombre parcial (opcional)
    List<Plan> findByNombrePlanContainingIgnoreCase(String nombrePlan);
}

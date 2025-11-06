package com.FitnessAppSpring.service;

import java.util.List;
import com.FitnessAppSpring.entity.Plan;

public interface PlanService {

    // 🟢 Listar todos los planes
    List<Plan> listarPlanes();

    // 🟢 Guardar o actualizar un plan
    Plan guardarPlan(Plan plan);

    // 🟢 Obtener un plan por ID
    Plan obtenerPlanPorId(Long id);

    // 🟢 Eliminar un plan
    void eliminarPlan(Long id);
}

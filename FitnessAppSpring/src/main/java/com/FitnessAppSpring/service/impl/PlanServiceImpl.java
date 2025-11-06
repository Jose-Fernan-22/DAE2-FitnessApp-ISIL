package com.FitnessAppSpring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FitnessAppSpring.entity.Plan;
import com.FitnessAppSpring.repository.PlanRepository;
import com.FitnessAppSpring.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> listarPlanes() {
        return planRepository.findAll();
    }

    @Override
    public Plan guardarPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan obtenerPlanPorId(Long id) {
        return planRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPlan(Long id) {
        planRepository.deleteById(id);
    }
}

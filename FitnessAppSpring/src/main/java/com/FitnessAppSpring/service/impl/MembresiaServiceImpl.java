package com.FitnessAppSpring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FitnessAppSpring.entity.Membresia;
import com.FitnessAppSpring.repository.MembresiaRepository;
import com.FitnessAppSpring.service.MembresiaService;

@Service
public class MembresiaServiceImpl implements MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public List<Membresia> listarTodos() {
        return membresiaRepository.findAll();
    }

    @Override
    public void guardar(Membresia membresia) {
        membresiaRepository.save(membresia);
    }

    @Override
    public Optional<Membresia> buscarPorId(Integer id) {
        return membresiaRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        membresiaRepository.deleteById(id);
    }
}

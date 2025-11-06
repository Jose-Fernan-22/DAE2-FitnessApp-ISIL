package com.FitnessAppSpring.service;

import java.util.List;
import java.util.Optional;

import com.FitnessAppSpring.entity.Membresia;

public interface MembresiaService {
    List<Membresia> listarTodos();
    void guardar(Membresia membresia);
    Optional<Membresia> buscarPorId(Integer id);
    void eliminar(Integer id);
}

package com.FitnessAppSpring.service;

import java.util.List;
import java.util.Optional;

import com.FitnessAppSpring.entity.Reclamo;

public interface ReclamoService {
	List<Reclamo> listarTodos();
	Reclamo guardar(Reclamo reclamo);
	Optional<Reclamo> buscarPorId(Integer id);
	
	void eliminar(Integer id);

}

package com.FitnessAppSpring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FitnessAppSpring.entity.Reclamo;
import com.FitnessAppSpring.repository.ReclamoRepository;
import com.FitnessAppSpring.service.ReclamoService;

@Service
public class ReclamoServiceImpl implements ReclamoService {
	
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	@Override
	public List<Reclamo> listarTodos() {
		return reclamoRepository.findAll();
	}
	
	@Override 
	public Reclamo guardar(Reclamo reclamo) {
		return reclamoRepository.save(reclamo);
	}
	
	@Override 
	public Optional<Reclamo> buscarPorId(Integer id) {
		return reclamoRepository.findById(id);
	}
	
	@Override 
	public void eliminar(Integer id) {
		reclamoRepository.deleteById(id);
	}
}

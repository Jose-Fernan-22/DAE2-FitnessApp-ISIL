package com.FitnessAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FitnessAppSpring.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByCorreoAndContrasenha(String correo, String contrasenha);
}

package com.FitnessAppSpring.service;


import java.util.List;

import com.FitnessAppSpring.entity.Usuario;


public interface UsuarioService {

	Usuario validarUsuario(String correo, String contrasenha);
	
	List<Usuario> listarUsuarios();
    Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    void eliminarUsuario(Long id);

}


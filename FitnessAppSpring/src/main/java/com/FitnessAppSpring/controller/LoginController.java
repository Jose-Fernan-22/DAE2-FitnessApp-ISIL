package com.FitnessAppSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.FitnessAppSpring.entity.Usuario;
import com.FitnessAppSpring.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String correo,
                               @RequestParam String contrasenha,
                               Model model) {

        Usuario usuario = usuarioService.validarUsuario(correo, contrasenha);

        if (usuario != null && "ADMIN".equalsIgnoreCase(usuario.getRol())) {
            model.addAttribute("usuario", usuario);
            return "home"; // página principal del admin
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }
}

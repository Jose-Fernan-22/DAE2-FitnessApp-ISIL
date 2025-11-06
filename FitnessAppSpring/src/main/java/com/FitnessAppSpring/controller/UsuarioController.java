package com.FitnessAppSpring.controller;

import com.FitnessAppSpring.entity.Usuario;
import com.FitnessAppSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
    private UsuarioService usuarioService;

    // 🟢 1️⃣ Listar todos los usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> lista = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", lista);
        return "usuarios"; // 👈 Thymeleaf -> templates/usuarios.html
    }

    // 🟢 2️⃣ Mostrar formulario para crear un nuevo usuario
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_form"; // 👈 templates/usuario_form.html
    }

    // 🟢 3️⃣ Guardar o actualizar un usuario
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios"; // 👈 vuelve al listado
    }

    // 🟢 4️⃣ Editar un usuario existente
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuario);
        return "usuario_form";
    }

    // 🟢 5️⃣ Eliminar un usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}

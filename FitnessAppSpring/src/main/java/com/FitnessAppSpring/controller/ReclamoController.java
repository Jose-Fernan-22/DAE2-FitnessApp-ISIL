package com.FitnessAppSpring.controller;

import com.FitnessAppSpring.entity.Reclamo;
import com.FitnessAppSpring.repository.UsuarioRepository;
import com.FitnessAppSpring.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;
    
    // Necesitamos el repositorio de Usuario para obtener la lista en el formulario
    @Autowired
    private UsuarioRepository usuarioRepository; 

    // 🟢 1️⃣ Listar todos los reclamos (READ)
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reclamos", reclamoService.listarTodos());
        return "reclamos_lista"; // 👈 Vista para mostrar la tabla de reclamos
    }

    // 🟢 2️⃣ Mostrar formulario para crear un nuevo reclamo (CREATE - Form)
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("reclamo", new Reclamo());
        // Pasamos la lista de usuarios para el <select> del formulario
        model.addAttribute("usuarios", usuarioRepository.findAll()); 
        model.addAttribute("estados", new String[]{"Pendiente", "En Proceso", "Resuelto"});
        return "reclamo_form"; // 👈 Vista del formulario de reclamo
    }

    // 🟢 3️⃣ Guardar o actualizar un reclamo (CREATE/UPDATE - Submit)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reclamo reclamo) {
        reclamoService.guardar(reclamo);
        return "redirect:/reclamos";
    }

    // 🟢 4️⃣ Mostrar formulario para editar un reclamo (UPDATE - Form)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Reclamo reclamo = reclamoService.buscarPorId(id).orElse(null);
        if (reclamo == null) {
            return "redirect:/reclamos";
        }
        model.addAttribute("reclamo", reclamo);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("estados", new String[]{"Pendiente", "En Proceso", "Resuelto"});
        return "reclamo_form";
    }

    // 🟢 5️⃣ Eliminar un reclamo (DELETE)
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reclamoService.eliminar(id);
        return "redirect:/reclamos";
    }
}

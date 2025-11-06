package com.FitnessAppSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.FitnessAppSpring.entity.Membresia;
import com.FitnessAppSpring.repository.PlanRepository;
import com.FitnessAppSpring.repository.UsuarioRepository;
import com.FitnessAppSpring.service.MembresiaService;

@Controller
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanRepository planRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("membresias", membresiaService.listarTodos());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("membresia", new Membresia());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("planes", planRepository.findAll());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Membresia membresia) {
        membresiaService.guardar(membresia);
        return "redirect:/membresias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Membresia membresia = membresiaService.buscarPorId(id).orElse(null);
        model.addAttribute("membresia", membresia);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("planes", planRepository.findAll());
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        membresiaService.eliminar(id);
        return "redirect:/membresias";
    }
}

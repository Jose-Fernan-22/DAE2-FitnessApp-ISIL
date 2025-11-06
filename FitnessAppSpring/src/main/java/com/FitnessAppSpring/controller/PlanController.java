package com.FitnessAppSpring.controller;

import com.FitnessAppSpring.entity.Plan;
import com.FitnessAppSpring.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    // 🟢 1️⃣ Listar todos los planes
    @GetMapping
    public String listarPlanes(Model model) {
        List<Plan> lista = planService.listarPlanes();
        model.addAttribute("planes", lista);
        return "planes"; // 👈 templates/planes.html
    }

    // 🟢 2️⃣ Mostrar formulario para crear un nuevo plan
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("plan", new Plan());
        return "plan_form"; // 👈 templates/plan_form.html
    }

    // 🟢 3️⃣ Guardar o actualizar un plan
    @PostMapping("/guardar")
    public String guardarPlan(@ModelAttribute Plan plan) {
        planService.guardarPlan(plan);
        return "redirect:/planes";
    }

    @GetMapping("/editar/{id}")
    public String editarPlan(@PathVariable("id") Long id, Model model) {
        Plan plan = planService.obtenerPlanPorId(id);
        if (plan == null) {
            return "redirect:/planes";
        }
        model.addAttribute("plan", plan);
        return "plan_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPlan(@PathVariable("id") Long id) {
        planService.eliminarPlan(id);
        return "redirect:/planes";
    }
}

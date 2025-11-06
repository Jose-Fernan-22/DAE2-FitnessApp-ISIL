package com.FitnessAppSpring.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "[Plan]")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan") // 👈 coincide con la BD
    private Long idPlan;

    @Column(name = "nombre_plan", nullable = false, length = 100)
    private String nombrePlan;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(name = "duracion_meses", nullable = false)
    private int duracionMeses;

    @Column(name = "entrenamientos_por_mes", nullable = false)
    private int entrenamientosPorMes;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "max_faltas_permitidas", nullable = false)
    private int maxFaltasPermitidas;

    // Getters y Setters
    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public int getEntrenamientosPorMes() {
        return entrenamientosPorMes;
    }

    public void setEntrenamientosPorMes(int entrenamientosPorMes) {
        this.entrenamientosPorMes = entrenamientosPorMes;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getMaxFaltasPermitidas() {
        return maxFaltasPermitidas;
    }

    public void setMaxFaltasPermitidas(int maxFaltasPermitidas) {
        this.maxFaltasPermitidas = maxFaltasPermitidas;
    }
}

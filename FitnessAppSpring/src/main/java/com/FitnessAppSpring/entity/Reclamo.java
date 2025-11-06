package com.FitnessAppSpring.entity;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "Reclamo") // Nombre de la tabla según el diagrama
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamo")
    private Integer idReclamo; // Usamos Integer como PK, siguiendo su indicación

    @ManyToOne // Relación Muchos Reclamos a Un Usuario
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_reclamo", nullable = false)
    private LocalDate fechaReclamo; // Tipo DATE, mapeado a LocalDate

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;
    
    @Column(name = "estado", length = 30, nullable = false)
    private String estado; // Para los estados: Pendiente, En Proceso, Resuelto

    // Constructor por defecto
    public Reclamo() {
        this.fechaReclamo = LocalDate.now(); // Inicializamos la fecha al crear la entidad
        this.estado = "Pendiente"; // Estado inicial por defecto
    }

    // Getters y Setters

    public Integer getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
package com.movilcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tiendas")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;

    private String nombre; // Ej: "Claro", "Entel"
    private String url_web; 
    private boolean activo; // Para "quitar" de la vista sin borrar el historial

    public Tienda() {}

    // Getters y Setters
    public Long getId() { return id_tienda; }
    public void setId(Long id) { this.id_tienda = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUrl_web() { return url_web; }
    public void setUrl_web(String url_web) { this.url_web = url_web; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}

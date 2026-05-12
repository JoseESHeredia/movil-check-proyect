package com.movilcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tiendas")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTienda;
    private String nombre;
    private String urlWeb;
    private boolean activo;

    public Tienda() {}

    // Getters y Setters
    public Long getIdTienda() { return idTienda; }
    public void setIdTienda(Long idTienda) { this.idTienda = idTienda; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUrlWeb() { return urlWeb; }
    public void setUrlWeb(String urlWeb) { this.urlWeb = urlWeb; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}

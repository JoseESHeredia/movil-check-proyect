package com.movilcheck.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipos")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;

    private String marca;
    private String modelo;
    private String procesador;
    private int ram;
    private int almacenamiento;
    private int bateria;
    private String camara;

    // Constructor vacío obligatorio para Spring Boot
    public Smartphone() {}

    // Getters y Setters
    public Long getId() { return id_equipo; }
    public void setId(Long id) { this.id_equipo = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(int almacenamiento) { this.almacenamiento = almacenamiento; }

    public int getBateria() { return bateria; }
    public void setBateria(int bateria) { this.bateria = bateria; }

    public String getCamara() { return camara; }
    public void setCamara(String camara) { this.camara = camara; }
}

package com.movilcheck.models;

public class EquipoModel {
    private int id;
    private String marca;
    private String modelo;
    private int ram;
    private int almacenamiento;
    private int camara;
    private int bateria;

    public EquipoModel(int id, String marca, String modelo, int ram, int almacenamiento, int camara, int bateria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.camara = camara;
        this.bateria = bateria;
    }

    // Getters para que el Frontend (React) pueda leer los datos
    public int getRam() { return ram; }
    public String getModelo() { return modelo; }
    // ... puedes agregar el resto de getters según necesites
}

package com.example.compara_planetas;

// Planeta.java
public class Planeta {
    private String nombre;
    private double diametro;
    private double distanciaAlSol;
    private int densidad;

    public Planeta(String nombre, double diametro, double distanciaAlSol, int densidad) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.distanciaAlSol = distanciaAlSol;
        this.densidad = densidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public int getDensidad() {
        return densidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

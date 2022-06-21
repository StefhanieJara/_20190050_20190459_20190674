package com.example._20190050_20190459_20190674.Beans;

public class Objetos {
    private int id_objeto;
    private String nombre_objeto;
    private float peso;
    private int tipo;

    private int id_vacuna;
    private float efectividad_vacunal;

    public int getId_objeto() {
        return id_objeto;
    }

    public void setId_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
    }

    public String getNombre_objeto() {
        return nombre_objeto;
    }

    public void setNombre_objeto(String nombre_objeto) {
        this.nombre_objeto = nombre_objeto;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(int id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public float getEfectividad_vacunal() {
        return efectividad_vacunal;
    }

    public void setEfectividad_vacunal(float efectividad_vacunal) {
        this.efectividad_vacunal = efectividad_vacunal;
    }
}

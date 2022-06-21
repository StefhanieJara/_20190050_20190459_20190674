package com.example._20190050_20190459_20190674.Beans;

import java.util.Date;

public class Zombie extends Humano {

    private Date tiempo_inf;
    private int id_virus;
    private String nombre_virus;
    private int num_victimas;
    private int id_zombie;
    private String nombre_zombie;
    private String nombre_variante;

    private float porcentaje_zombie;

    public float getPorcentaje_zombie() {
        return porcentaje_zombie;
    }

    public void setPorcentaje_zombie(float porcentaje_zombie) {
        this.porcentaje_zombie = porcentaje_zombie;
    }

    public Date getTiempo_inf() {
        return tiempo_inf;
    }

    public void setTiempo_inf(Date tiempo_inf) {
        this.tiempo_inf = tiempo_inf;
    }

    public int getId_virus() {
        return id_virus;
    }

    public void setId_virus(int id_virus) {
        this.id_virus = id_virus;
    }

    public String getNombre_virus() {
        return nombre_virus;
    }

    public void setNombre_virus(String nombre_virus) {
        this.nombre_virus = nombre_virus;
    }

    public int getNum_victimas() {
        return num_victimas;
    }

    public void setNum_victimas(int num_victimas) {
        this.num_victimas = num_victimas;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    public String getNombre_zombie() {
        return nombre_zombie;
    }

    public void setNombre_zombie(String nombre_zombie) {
        this.nombre_zombie = nombre_zombie;
    }

    public String getNombre_variante() {
        return nombre_variante;
    }

    public void setNombre_variante(String nombre_variante) {
        this.nombre_variante = nombre_variante;
    }
}

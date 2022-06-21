package com.example._20190050_20190459_20190674.Beans;

public class Virus {
    private String idVirus;
    private String nombre_virus;
    private String idVariante;
    private String nombre_variante;
    private int casos_encontrados;


    private int casos_totales;

    public String getIdVirus() {
        return idVirus;
    }

    public void setIdVirus(String idVirus) {
        this.idVirus = idVirus;
    }

    public String getNombre_virus() {
        return nombre_virus;
    }

    public void setNombre_virus(String nombre_virus) {
        this.nombre_virus = nombre_virus;
    }

    public String getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(String idVariante) {
        this.idVariante = idVariante;
    }

    public String getNombre_variante() {
        return nombre_variante;
    }

    public void setNombre_variante(String nombre_variante) {
        this.nombre_variante = nombre_variante;
    }

    public int getCasos_encontrados() {
        return casos_encontrados;
    }

    public void setCasos_encontrados(int casos_encontrados) {
        this.casos_encontrados = casos_encontrados;
    }

    public int getCasos_totales() {
        return casos_totales;
    }

    public void setCasos_totales(int casos_totales) {
        this.casos_totales = casos_totales;
    }
}

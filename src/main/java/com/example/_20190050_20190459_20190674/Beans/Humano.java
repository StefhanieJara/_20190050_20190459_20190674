package com.example._20190050_20190459_20190674.Beans;


public class Humano {
    private String Id;
    private String nombre_apellido;
    private String sexo;
    private String estado_rol;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_rol() {
        return estado_rol;
    }

    public void setEstado_rol(String estado_rol) {
        this.estado_rol = estado_rol;
    }
}

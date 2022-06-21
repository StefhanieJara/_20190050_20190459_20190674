package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Humano;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HumanoDao extends DaoBase{
    public ArrayList<Humano> obtenerPerfil() {

        ArrayList<Humano> listaHumano = new ArrayList<>();


        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idHumano, nombre_apellido, Sexo, r.nombre\n" +
                     "from humanos h, rol r \n" +
                     "where h.Rol_idRol=r.idRol;\n");) {
            while (rs.next()) {
                Humano humano = new Humano();
                humano.setId(rs.getInt(1));
                humano.setNombre_apellido(rs.getString(2));
                humano.setSexo(rs.getString(3));
                humano.setEstado_rol(Integer.parseInt(rs.getString(4)));
                listaHumano.add(humano);
            }


        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaHumano;
    }


}

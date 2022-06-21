package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Humano;
import java.sql.*;
import java.util.ArrayList;

public class HumanoDao extends DaoBase{
    public ArrayList<Humano> obtenerLista() {

        ArrayList<Humano> listaHumano = new ArrayList<>();


        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select h.idHumano, h.nombre_apellido, h.Sexo, r.nombre\n" +
                     "from humanos h\n" +
                     "inner join rol r on h.Rol_idRol=r.idRol;");) {

            while (rs.next()) {
                Humano humano = new Humano();
                humano.setId(rs.getString(1));
                humano.setNombre_apellido(rs.getString(2));
                humano.setSexo(rs.getString(3));
                humano.setEstado_rol(rs.getString(4));
                listaHumano.add(humano);
            }
            System.out.println(listaHumano);

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaHumano;
    }


}

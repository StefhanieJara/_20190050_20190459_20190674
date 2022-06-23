package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Superviviente;
import com.example._20190050_20190459_20190674.Beans.Zombie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CaceriaDao extends  DaoBase{
    public ArrayList<Superviviente> obtenerSuperviviente(){

        ArrayList<Superviviente> listaSuperviviente = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select h.idHumano, h.nombre_apellido, hto.cantidad\n" +
                     "from Humanos h, humano_tiene_objetos hto, objetos o\n" +
                     "where h.idHumano=hto.idHumano and\n" +
                     "      hto.idObjetos = o.idObjetos and Vacuna_idVacuna>0\n" +
                     "      and h.Rol_idRol=1\n" +
                     "      group by h.idHumano;");){
            while (rs.next()){
                Superviviente superviviente = new Superviviente();
                superviviente.setId(rs.getString(1));
                superviviente.setNombre_apellido(rs.getString(2));
                superviviente.setCantidad_vacunas(rs.getInt(3));

                listaSuperviviente.add(superviviente);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSuperviviente;
    }
}

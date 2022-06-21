package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Objetos;
import com.example._20190050_20190459_20190674.Beans.Zombie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ObjetosDao extends DaoBase {

    public ArrayList<Objetos> obtenerObjetos(){

        ArrayList<Objetos> listaObjetos = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from objetos;");){
            while (rs.next()){
                Objetos objetos= new Objetos();
                objetos.setId_objeto(rs.getInt(1));
                objetos.setNombre_objeto(rs.getString(2));
                objetos.setPeso(rs.getFloat(3));
                objetos.setId_vacuna(rs.getInt(4));

                listaObjetos.add(objetos);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaObjetos;
    }

    public ArrayList<Objetos> obtenerVacunas_Efectividad(){

        ArrayList<Objetos> listaObjetos = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idVacuna, ef.idEfectividad ,ef.porcentaje, tz.tipo \n" +
                     "from vacuna v, efectividad ef, tipo_zombie tz\n" +
                     "where v.idEfectividad=ef.idEfectividad and\n" +
                     "      ef.idTipo_Zombie=tz.idTipo_Zombie;");){
            while (rs.next()){
                Objetos objetos= new Objetos();
                objetos.setId_objeto(rs.getInt(1));
                objetos.setNombre_objeto(rs.getString(2));
                objetos.setPeso(rs.getFloat(3));
                objetos.setId_vacuna(rs.getInt(4));

                listaObjetos.add(objetos);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaObjetos;
    }


}

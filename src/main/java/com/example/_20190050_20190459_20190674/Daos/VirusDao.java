package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Virus;

import java.sql.*;
import java.util.ArrayList;

public class VirusDao extends DaoBase{

    public ArrayList<Virus> obtenerVirus(){

        ArrayList<Virus> listaVirus = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select v.id_virus, v.nombre, v.idVariante, var.nombre, count(h.id_Virus) as 'Casos encontrados' \n" +
                     "from virus v\n" +
                     "left join variante var on v.id_Virus = var.idVariante\n" +
                     "left join humanos h on v.id_Virus=h.id_Virus\n" +
                     "group by v.id_Virus\n" +
                     "order by v.id_Virus asc;");){
            while (rs.next()){
                Virus virus= new Virus();
                virus.setIdVirus(rs.getString(1));
                virus.setNombre_virus(rs.getString(2));
                virus.setIdVariante(rs.getString(3));
                virus.setNombre_variante(rs.getString(4));
                virus.setCasos_encontrados(rs.getInt(5));
                listaVirus.add(virus);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaVirus;
    }

    public Virus casos_totales() {
        Virus virus = null;

        String sql = "select count(v.id_Virus) as 'Casos activos' \n" +
                "from virus v, humanos h\n" +
                "where v.id_Virus=h.id_Virus ";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    virus = new Virus();
                    virus.setCasos_totales(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return virus;
    }


    public void crear_variante(String nombre_variante) {

        String sql = "INSERT INTO variante (nombre) VALUES (?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, nombre_variante);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarVariante(String idVariante) {
        String sql = "DELETE FROM variante WHERE (idVariante = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, idVariante);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminarVirus(String idVariante) {
        String sql = "DELETE FROM virus WHERE (idVariante = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, idVariante);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarZombies(String idVirus) {
        String sql = "DELETE FROM humanos WHERE (id_Virus = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, idVirus);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

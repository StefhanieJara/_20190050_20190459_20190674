package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Virus;

import java.sql.*;
import java.util.ArrayList;

public class VirusDao extends DaoBase{

    public ArrayList<Virus> obtenerVirus(){

        ArrayList<Virus> listaVirus = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select v.id_virus, v.nombre, var.idVariante, var.nombre, count(h.variante_idVariante) as 'Casos encontrados'\n" +
                     "from virus v left join variante var on v.id_Virus = var.Virus_id_Virus left join humanos h on var.idVariante=h.variante_idVariante\n" +
                     "group by var.idVariante order by var.idVariante asc;");){
            while (rs.next()){
                Virus virus= new Virus();
                virus.setIdVirus(rs.getInt(1));
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

    public ArrayList<Virus> obtenerVirus_sinRepetir(){

        ArrayList<Virus> listaVirusRepetir = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select nombre from virus;");){
            while (rs.next()){
                Virus virus= new Virus();
                virus.setNombre_virus(rs.getString(1));
                listaVirusRepetir.add(virus);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaVirusRepetir;
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


    public void crear_variante(String nombre_variante, int Id_virus) {

        String sql = "INSERT INTO variante (nombre, Virus_id_Virus) VALUES (? , ?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, nombre_variante);
            pstmt.setInt(2, Id_virus);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int encontrarIDVirus(String nombre){
        int id=0;
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from virus where nombre like ?")){
            stmt.setString(1, "%"+nombre+"%");
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    id=rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }







    public void crear_virus(String nombre_variante) {

        String sql = "INSERT INTO virus (nombre) VALUES (?);";

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

    public void eliminarVirus(String idVirus) {
        String sql = "DELETE FROM virus WHERE (id_Virus = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, idVirus);

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

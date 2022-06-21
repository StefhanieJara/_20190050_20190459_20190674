package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Objetos;
import com.example._20190050_20190459_20190674.Beans.Superviviente;
import com.example._20190050_20190459_20190674.Beans.Zombie;

import java.sql.*;
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

    public void crearObjeto_normal(String nombre, Float peso) {

        String sql = "INSERT INTO objetos (`nombre`, `peso`) VALUES (?, ?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, nombre);
            pstmt.setFloat(2,peso);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearVacuna(String idEfectividad) {

        String sql = "INSERT INTO vacuna (`idEfectividad`) VALUES (?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, idEfectividad);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearVacuna_objeto(String nombre, float peso, String idVacuna) {

        String sql = "INSERT INTO objetos (`nombre`, `peso`, `Vacuna_idVacuna`) VALUES (?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, nombre);
            pstmt.setFloat(2,peso);
            pstmt.setString(3,idVacuna);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarObjetos(Objetos objetos) {

        String sql = "UPDATE objetos SET `peso` = ? WHERE (`idObjetos` = ?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setFloat(1, objetos.getPeso());
            pstmt.setInt(2, objetos.getId_objeto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarEfictividad_vacuna(Objetos objetos) {

        String sql = "UPDATE vacuna SET `idEfectividad` = ? WHERE (`idVacuna` = ?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, objetos.getId_efectividad());
            pstmt.setFloat(2, objetos.getId_vacuna());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

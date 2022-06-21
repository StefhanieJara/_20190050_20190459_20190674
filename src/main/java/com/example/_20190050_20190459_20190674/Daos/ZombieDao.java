package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Virus;
import com.example._20190050_20190459_20190674.Beans.Zombie;

import java.sql.*;
import java.util.ArrayList;

public class ZombieDao extends DaoBase{

    public ArrayList<Zombie> obtenerZombies(){

        ArrayList<Zombie> listaZombie = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idHumano, nombre_apellido, Sexo, tiempo_inf, var.nombre, victimas, z.tipo, h.id_Virus\n" +
                     "                     from Humanos h, virus v, variante var, tipo_zombie z \n" +
                     "                     where h.id_Virus = v.id_Virus and\n" +
                     "                           v.id_Virus = var.Virus_id_Virus and \n" +
                     "                           h.idTipo_zombie = z.idTipo_Zombie;");){
            while (rs.next()){
                Zombie zombie= new Zombie();
                zombie.setId(rs.getString(1));
                zombie.setNombre_apellido(rs.getString(2));
                zombie.setSexo(rs.getString(4));
                zombie.setTiempo_inf(rs.getTime(4));
                zombie.setNombre_variante(rs.getString(5));
                zombie.setNum_victimas(rs.getInt(6));
                zombie.setNombre_zombie(rs.getString(7));
                zombie.setId_virus(rs.getInt(8));

                listaZombie.add(zombie);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaZombie;
    }

    public void crearZombie(String idHumano, String nombre_apellido, String sexo, Date tiempo_inf, String id_virus, String tipo_zombie) {

        String sql = "INSERT INTO humanos (`idHumano`, `nombre_apellido`, `Sexo`, `Rol_idRol`, `fuerza`, `peso`, `tiempo_inf`, `victimas`, `id_Virus`, `idTipo_Zombie`) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, idHumano);
            pstmt.setString(2,nombre_apellido);
            pstmt.setString(3,sexo);
            pstmt.setString(4,"2");
            pstmt.setFloat(5,50);
            pstmt.setFloat(6,50);
            pstmt.setDate(7,tiempo_inf);
            pstmt.setInt(8,0);
            pstmt.setString(9,id_virus);
            pstmt.setString(10,tipo_zombie);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Virus modaEncontrada(String id) {
        Virus virus = null;

        String sql = "select nombre from virus where id_Virus = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    virus = new Virus();
                    virus.setNombre_virus(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return virus;
    }

    public Zombie porcentajeSexo(String sexo) {
        Zombie zombie = null;

        String sql = "select truncate(count(idHumano)/(select count(idHumano) as 'Cantidad de Zombies' from humanos where rol_idRol = '2')*100,2) as 'Porcentaje ' \n" +
                "from humanos where rol_idRol =? and Sexo = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, "2");
            pstmt.setString(2, sexo);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    zombie = new Zombie();
                    zombie.setPorcentaje_zombie(rs.getFloat(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return zombie;
    }

    public Zombie victimas(String tipo_zombie) {
        Zombie zombie = null;

        String sql = "select truncate(avg(victimas),2) from humanos\n" +
                "where idTipo_Zombie = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, tipo_zombie);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    zombie = new Zombie();
                    zombie.setNum_victimas(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return zombie;
    }

}

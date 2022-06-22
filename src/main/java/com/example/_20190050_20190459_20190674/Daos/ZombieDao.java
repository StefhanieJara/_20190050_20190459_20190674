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
             ResultSet rs = stmt.executeQuery("select idHumano, nombre_apellido, Sexo, var.nombre, victimas, z.tipo, h.variante_idVariante,var.Virus_id_Virus ,truncate(time_to_sec(min(TIMEDIFF(now(), tiempo_inicio))),0)/60 as 'tiempo_infectado', estado\n" +
                     "                     from Humanos h, virus v, variante var, tipo_zombie z\n" +
                     "                        where h.variante_idVariante = var.idVariante and\n" +
                     "                       var.Virus_id_Virus = v.id_Virus and \n" +
                     "                      h.idTipo_zombie = z.idTipo_Zombie\n" +
                     "                     group by idHumano;");){
            while (rs.next()){
                Zombie zombie= new Zombie();
                zombie.setId(rs.getString(1));
                zombie.setNombre_apellido(rs.getString(2));
                zombie.setSexo(rs.getString(4));
                zombie.setNombre_variante(rs.getString(4));
                zombie.setNum_victimas(rs.getInt(5));
                zombie.setNombre_zombie(rs.getString(6));
                zombie.setId_variante(rs.getInt(7));
                zombie.setId_virus(rs.getInt(8));
                zombie.setTiempo_inf(rs.getFloat(9));
                zombie.setEstado(rs.getInt(10));

                listaZombie.add(zombie);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaZombie;
    }

    public ArrayList<Virus> obtenerVariantes(){

        ArrayList<Virus> listaVariantes = new ArrayList<>();
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM variante;");){
            while (rs.next()){
                Virus virus= new Virus();
                virus.setIdVariante(rs.getString(1));
                virus.setNombre_variante(rs.getString(2));
                virus.setIdVirus(Integer.parseInt(rs.getString(3)));
                listaVariantes.add(virus);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaVariantes;
    }


    public void crearZombie(String nombre_apellido, String sexo, String tipo_zombie, String id_variante) {

        String sql = "INSERT INTO humanos (`idHumano`, `nombre_apellido`, `Sexo`, `Rol_idRol`, `fuerza`, `peso`, `victimas`, `idTipo_Zombie`, `variante_idVariante`, `tiempo_inicio`, `estado`) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            String id="";
            String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
            for (int i = 0; i < 11; i++ ) {
                id += nums[(int) Math.round(Math.random() * 9)];
            }

            pstmt.setString(1, id);
            pstmt.setString(2,nombre_apellido);
            pstmt.setString(3,sexo);
            pstmt.setString(4,"2");
            pstmt.setFloat(5, 50.0F);
            pstmt.setFloat(6,50.0f);
            pstmt.setInt(7,0);
            pstmt.setString(8,tipo_zombie);
            pstmt.setString(9,id_variante);
            pstmt.setString(10, "2022-6-21 00:00:00");
            pstmt.setInt(11,1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Virus modaEncontrada(String id) {
        Virus virus = null;

        String sql = "select nombre from variante where idVariante = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    virus = new Virus();
                    virus.setNombre_variante(rs.getString(1));
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
                    zombie.setProm_victimas(rs.getFloat(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return zombie;
    }

}
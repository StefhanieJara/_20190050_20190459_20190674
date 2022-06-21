package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Humano;
import com.example._20190050_20190459_20190674.Beans.Superviviente;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class SupervivientesDao extends DaoBase {

    public ArrayList<Superviviente> obtenerLista(String parametro) {

        ArrayList<Superviviente> listasupervivientes = new ArrayList<>();

        String sql = null;
        if(parametro==null){
            sql = "select h.idHumano, h.nombre_apellido, h.sexo, h.peso, h.fuerza, hum.nombre_apellido\n" +
                    "from Humanos h\n" +
                    "left join Humanos hum on h.idHumano_pareja = hum.idHumano where h.Rol_idRol='1';\n";
        }else {
            if(parametro.equals("M")){
                sql = "select h.idHumano, h.nombre_apellido, h.sexo, h.peso, h.fuerza, hum.nombre_apellido\n" +
                        "from Humanos h\n" +
                        "left join Humanos hum on h.idHumano_pareja = hum.idHumano where h.Rol_idRol='1' and h.sexo='M'\n;";
            }else if(parametro.equals("F")){
                sql = "select h.idHumano, h.nombre_apellido, h.sexo, h.peso, h.fuerza, hum.nombre_apellido\n" +
                        "from Humanos h\n" +
                        "left join Humanos hum on h.idHumano_pareja = hum.idHumano where h.Rol_idRol='1' and h.sexo='F'\n;";
            }else if(parametro.equals("O")){
                sql = "select h.idHumano, h.nombre_apellido, h.sexo, h.peso, h.fuerza, hum.nombre_apellido\n" +
                        "from Humanos h\n" +
                        "left join Humanos hum on h.idHumano_pareja = hum.idHumano where h.Rol_idRol='1' and h.sexo='O'\n;";
            }else{
                sql = "select h.idHumano, h.nombre_apellido, h.sexo, h.peso, h.fuerza, hum.nombre_apellido\n" +
                        "from Humanos h\n" +
                        "left join Humanos hum on h.idHumano_pareja = hum.idHumano where h.Rol_idRol='1';\n";
            }
        }
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                Superviviente superviviente = new Superviviente();
                superviviente.setId(rs.getString(1));
                superviviente.setNombre_apellido(rs.getString(2));
                superviviente.setSexo(rs.getString(3));
                superviviente.setPeso(rs.getFloat(4));
                superviviente.setFuerza(rs.getFloat(5));
                superviviente.setPareja(rs.getString(6));
                
                listasupervivientes.add(superviviente);
            }


        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listasupervivientes;
    }

    public void actualizarSuperviviente(Superviviente superviviente) {

        String sql = "UPDATE humanos SET nombre_apellido = ?, fuerza = ?, peso = ?, idHumano_pareja = ? WHERE (idHumano = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, superviviente.getNombre_apellido());
            pstmt.setFloat(2, superviviente.getFuerza());
            pstmt.setFloat(3, superviviente.getPeso());
            pstmt.setString(4,superviviente.getPareja());
            pstmt.setString(5,superviviente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearSupervivencia(String id,String nombre_apellido,String sexo,float fuerza, float peso) {

        String sql = "INSERT INTO humanos (idHumano, nombre_apellido, Sexo, Rol_idRol, fuerza, peso) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);
            pstmt.setString(2, nombre_apellido);
            pstmt.setString(3, sexo);
            pstmt.setInt(4, 1);
            pstmt.setFloat(5,fuerza);
            pstmt.setFloat(6, peso);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarSuperviviente(String id) {

        String sql = "DELETE FROM humanos WHERE (idHumano = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPareja(String id) {


        String sql = "UUPDATE humanos SET idHumano_pareja = '' WHERE (idHumano = ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

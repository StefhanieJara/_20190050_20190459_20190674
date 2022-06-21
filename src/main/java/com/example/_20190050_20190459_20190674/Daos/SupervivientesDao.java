package com.example._20190050_20190459_20190674.Daos;

import com.example._20190050_20190459_20190674.Beans.Superviviente;

import java.sql.*;
import java.util.ArrayList;

public class SupervivientesDao extends DaoBase {
    /*public ArrayList<Superviviente> listarSupervivientes(){
        ArrayList<Superviviente> listaSupervivientes= new ArrayList<>();
            String sql="select * from humano where idSuperviviente=?;";
            try(Connection conn= this.getConnection();
                PreparedStatement pstmt= conn.prepareStatement(sql)){
                pstmt.setInt(1,id_int);
                try(ResultSet resultSet= pstmt.executeQuery()){
                    while(resultSet.next()){
                        Superviviente superviviente= new Superviviente();
                        superviviente.setId(resultSet.getInt(1));
                        superviviente.setNombre_apellido(resultSet.getString(2));
                        superviviente.setSexo(resultSet.getString(3));
                        superviviente.setNombre_apellido(resultSet.getString(3));
                        listaSupervivientes.add(superviviente);
                    }
                }
            }catch(SQLException e) {
                System.out.println("Hubo un error en la conexión!");
                e.printStackTrace();
            }
        return listaSupervivientes;
    }*/



}

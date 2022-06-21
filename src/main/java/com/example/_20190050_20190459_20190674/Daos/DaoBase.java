
package com.example._20190050_20190459_20190674.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public abstract class DaoBase {
        public Connection getConnection() throws SQLException {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://localhost:3306/lab5_20190050";
            return DriverManager.getConnection(url,user,pass);
        }

    }


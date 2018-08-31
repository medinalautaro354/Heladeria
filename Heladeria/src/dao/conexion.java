/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumno
 */
public class conexion {

    String jdbc_driver = "com.mysql.jdbc.Driver";
    String jdbc_url = "jdbc:mysql://localhost:3306/";
    String jdbc_user = "root";
    String jdbc_pass = "";
    String bd = "Heladeria";

    private static Connection cn;

    public conexion() {

        try {
            Class.forName(jdbc_driver);
            cn = DriverManager.getConnection(jdbc_url + bd, jdbc_user, jdbc_pass);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public Connection RetornarConeccion() {
        return cn;
    }
}

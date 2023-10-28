package com.engiri;

import java.sql.*;

public class App01 {

    // Datos conexión con la BD
    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo2";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {
        try {

            // 1. Establecer la conexión
            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

            // 2. Enviar procedimiento almacenado
            String sql = "{ call matricular1 (?,?) }";
            CallableStatement sentencia = conexion.prepareCall(sql);

            // 3. Asignamos valor a los argumentos
            sentencia.setInt(1, 1);
            sentencia.setInt(2, 10);
            sentencia.execute();
            System.out.println("Matriculacion realizada.");

            // 4. Cerrar conexiones
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
    }
}

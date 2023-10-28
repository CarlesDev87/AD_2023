package org.example;

import java.sql.*;


public class App {
    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {
        try {
// 1. Establecer la conexión

            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

// 2. Enviar sentencias

            String sql = "INSERT INTO articulos "
                    + "(id, nombre, precio, stock, imagen, descripcion) "
                    + "VALUES('b1', 'Bicicleta', 450.00, 5, NULL, 'BH')";

            System.out.println(sql);

            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);

// 3. Procesar los resultados

            System.out.println("Filas insertadas: " + filas);

// 4. Cerrar conexiones

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }


    }
}
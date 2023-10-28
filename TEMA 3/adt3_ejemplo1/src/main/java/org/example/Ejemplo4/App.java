package org.example.Ejemplo4;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class App {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
// 1. Establecer la conexión

            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

// 2. Enviar sentencia SELECT
            String sql = "SELECT nombre, precio, stock "
                    + "FROM articulos;";
            Statement sentencia = conexion.createStatement();
            ResultSet filas = sentencia.executeQuery(sql);
// 3. Procesar los resultados
            while (filas.next()) {
                String nombre = filas.getString("nombre");
                float precio = filas.getFloat("precio");
                int stock = filas.getInt("stock");
                System.out.println("Artículo: " + nombre
                        + " " + precio + "€ "
                        + "- Unidades: " + stock);
            }

// 4. Cerrar conexiones

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }

    }
}

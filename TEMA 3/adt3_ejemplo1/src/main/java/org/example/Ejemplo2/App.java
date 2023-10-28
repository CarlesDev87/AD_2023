package org.example.Ejemplo2;

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

            // 2. Enviar sentencia UPDATE
            String sql = "UPDATE articulos SET stock = ?;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, 10);
            int filas = sentencia.executeUpdate();
// 4. Procesar los resultados
            System.out.println("Filas actualizadas: " + filas);

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

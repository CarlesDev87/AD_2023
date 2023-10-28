package org.example.Ejemplo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
// 1. Establecer la conexión

            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

// 2. Enviar sentencias

            // 2. Enviar sentencia DELETE
            String sql = "DELETE FROM articulos WHERE stock < ?;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, 0);
            int filas = sentencia.executeUpdate();
// 3. Procesar los resultados
            System.out.println("Filas borradas: " + filas);

// 4. Cerrar conexiones

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }

    }
}

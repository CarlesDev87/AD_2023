package org.example;

import java.sql.*;
import java.util.Scanner;

public class App {
    //CREAMOS LAS VARIABLES PARA LA CONEXION

    public static final String URL = "jdbc:mysql://localhost/adt3_practica1";
    public static final String USER = "root";
    public static final String PWD = "";
   public static final Connection conexion;

    static {
        try {
            conexion = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {


        int opcion;


        do {
            mostrarMenu();
            System.out.println("¿Que quiere hacer?");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    insertarEmpleado();
                    break;
                case 2:
                    borrarEmpleado();
                    break;
                case 3:
                    listarEmpleados();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    try {
                        conexion.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione una opción del menú.");
                    break;


            }
        } while (opcion != 4);

        entrada.close();

    }


    public static void mostrarMenu() {

        String s = """
                                
                =========================================
                |                                       |  
                |   1.- Insertar empleado nuevo         |
                |   2.- Borrar empleado dado su dni     |
                |   3.- Listar todos los empleados      |
                |   4.- Salir                           |
                |                                       |
                =========================================
                """;
        System.out.println(s);
    }

    public static void insertarEmpleado() {
        try {


            String sql = "INSERT INTO empleados"
                    + "(dni, nombre, apellidos, edad, salario )"
                    + "VALUES('20455667J', 'Mariano', 'Delgado', '45', '20500')";
            System.out.println(sql);

            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);

            System.out.println("Filas insertadas: " + filas);

            sentencia.close();

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e);
        }
    }

    public static void borrarEmpleado() {

        try {
// 1. Establecer la conexión



// 2. Enviar sentencias

            // 2. Enviar sentencia DELETE
            String sql = "DELETE FROM empleados WHERE dni = ?;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, "20455678H");
            int filas = sentencia.executeUpdate();
// 3. Procesar los resultados
            System.out.println("Filas borradas: " + filas);

// 4. Cerrar conexiones

            sentencia.close();

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }
    }

    public static void listarEmpleados() {
        try {
// 1. Establecer la conexión



// 2. Enviar sentencia SELECT
            String sql = "SELECT *"
                    + "FROM empleados;";
            Statement sentencia = conexion.createStatement();
            ResultSet filas = sentencia.executeQuery(sql);
// 3. Procesar los resultados
            while (filas.next()) {
                String dni = filas.getString("dni");
                String nombre = filas.getString("nombre");
                String apellidos = filas.getString("apellidos");
                int edad = filas.getInt("edad");
                double salario = filas.getDouble("salario");
                System.out.println("Dni:" + dni
                        + ", " + " Nombre: " + nombre
                        + ", " + "Apellidos: " + apellidos
                        + ", " + "Edad: " + edad
                        + ", " + "Salario: " + (int) salario + "€");
            }

// 4. Cerrar conexiones

            sentencia.close();

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }
    }


}





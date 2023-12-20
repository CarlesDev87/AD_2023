package org.example;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        try {
            Connection accesoBD = GestionBD.getConexion();
        } catch (Exception e) {
            System.err.println("Error SQL" + e.getMessage());

        }
    }


}
package org.example;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class App1 {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        menu();


    }

    public static void menu() {
        int opcion;

        do {
            System.out.println("\n");
            System.out.println("1.- Leer desde fichero");
            System.out.println("2.- Escribir en el fichero");
            System.out.println("3.- Fin");
            System.out.println();
            System.out.println("=========================================");
            System.out.println();

            System.out.println("Seleccione una opción");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    leerFichero();
                    break;
                case 2:
                    escribirFichero();
                    break;

                case 3:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción no válida");

            }
        } while (opcion != 3);
    }

    public static void leerFichero() {

    File fichero = null;
    BufferedReader br = null;

        try {

            System.out.println("Introduce la ruta del fichero a leer");
            String direccion;
            direccion = scanner.nextLine();
            fichero = new File(direccion);
            br = new BufferedReader(new FileReader(fichero));
            String linea = null;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void escribirFichero() {
    FileWriter fichero = null;
    PrintWriter pw = null;
        try {
            System.out.println("Introduce la ruta del fichero a leer");
            String direccion;
            direccion = scanner.nextLine();
            fichero = new FileWriter(direccion);

            pw = new PrintWriter(fichero);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
package com.engiri;

import java.io.*;
import java.util.Scanner;

public class App05 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        File origen = new File("./src/main/resources/ejercicio5.txt");
        BufferedReader br = null;

        int cont = 0;
        String str = "";

        try {
            System.out.print("Palabra a buscar: ");
            String palabra = in.next();

            br = new BufferedReader(new FileReader(origen));
            String linea = br.readLine();

            while (linea != null) {
                cont++;
                String[] palabras = linea.split(" ");
                for(int x = 0; x < palabras.length; x++) {
                    str = palabras[x];
                    if (str.equalsIgnoreCase(palabra)) {
                        System.out.println("Encontrado en la línea: " + cont + " - " + linea);
                    }
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                br.close();
                in.close();
            } catch (IOException e) {
                System.out.println("Error en el finally.");
            }

        }

    }
}

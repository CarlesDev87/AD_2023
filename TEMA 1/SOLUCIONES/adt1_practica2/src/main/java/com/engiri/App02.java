package com.engiri;


import java.io.*;

public class App02 {


    public static void main(String[] args) {
        File origen = new File("./src/main/resources/ejercicio2.txt");
        File destino = new File("./src/main/resources/ejercicio2Final.txt");

        // Origen
        FileReader fr = null;
        BufferedReader br = null;

        // Destino
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            // Origen
            fr = new FileReader(origen);
            br = new BufferedReader(fr);

            // Destino
            fw = new FileWriter(destino);
            pw = new PrintWriter(fw);

            String cadena = br.readLine();

            while (cadena != null) {
                pw.println(cadena.toUpperCase());
                cadena = br.readLine();
            }


            // Problema en Windows en Linux funciona perfecte
            /*
             * if(destino.renameTo(origen)) System.out.println("OK"); else
             * System.out.println("NO OK");
             */

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {

                br.close();
                pw.close();

            } catch (IOException e) {
                System.out.println("Error en el finally.");
            }

        }

    }

}

package org.example;

import java.io.*;

public class App2 {
    public static void main(String[] args) {
        try {
            File archivo = new File("C://Users/prosi/OneDrive/DAM/2º DAM/AD- Acceso a datos/TEMA 1/PRACTICAS/adt1_practica2/src/main/resources/fichero3.txt");
            File archivoNuevo = new File("C://Users/prosi/OneDrive/DAM/2º DAM/AD- Acceso a datos/TEMA 1/PRACTICAS/adt1_practica2/src/main/resources/ficheroCopia.txt");

            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(archivoNuevo);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;

            while ((linea = br.readLine()) != null) {
                String lineaMayusculas = linea.toUpperCase();
                bw.write(lineaMayusculas);
                bw.newLine();
            }

            br.close();
            bw.close();

        } catch (IOException e) {
            System.out.println("El fichero no existe.");
        }
    }



}

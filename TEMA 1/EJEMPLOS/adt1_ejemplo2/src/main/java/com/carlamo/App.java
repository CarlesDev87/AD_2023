package com.carlamo;


import java.io.File;

public class App {
    public static void main(String[] args) {
       String directorioRaiz = File.listRoots()[0].toString();
       File[] paths = File.listRoots();
       File direcC = new File("C:/");

        System.out.println("=========================================");
        System.out.println("Directorio raíz: " + directorioRaiz);

        System.out.println("=========================================");
        System.out.println("Unidades de disco:");
        for (File fich : paths) {
            System.out.println("\t" + fich.toString());
        }
        System.out.println("==================================================");
        System.out.println("Los archivos y/o carpetas que contiene " + direcC);
        for (File f : direcC.listFiles()) {
            System.out.println("\t" + f + (f.isFile() ? " - fichero" : " - directorio"));
        }
        System.out.println("==================================================");
        System.out.println("Los nombres de los archivos y/o carpetas que contiene " +
                direcC);
        for (String f : direcC.list()) {
            System.out.println("\t" + f);
        }
    }
}
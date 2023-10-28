package com.carlamo;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) {

        File f = new File("src/main/resources/ejemplo1.txt");
        if (f.exists()) {
            System.out.println("El fichero existe");
        }
        else {
            System.err.println("El fichero no existe");
        }

        System.out.println("getName()" + f.getName());
        System.out.println("getParent()" + f.getParent());
        System.out.println("length()" + f.length());




    }
}
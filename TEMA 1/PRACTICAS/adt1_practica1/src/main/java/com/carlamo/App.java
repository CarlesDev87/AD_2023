package com.carlamo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {
    private static GestionArchivos g1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        crearMenu();
    }

    public static void crearMenu() {

        g1 = new GestionArchivos();
        int opcion;

        do {
            System.out.println("\n");
            System.out.println("1.- Asignar ruta de trabajo");
            System.out.println("2.- Listado de la ruta de trabajo");
            System.out.println("3.- Información detallada de un archivo");
            System.out.println("4.- Creación de un directorio");
            System.out.println("5.- Creación de un fichero");
            System.out.println("6.- Eliminación de un fichero");
            System.out.println("7.- Salir");
            System.out.println();
            System.out.println("=========================================");
            System.out.println();

            System.out.println("Seleccione una opción");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    asignarRutaTrabajo();
                    break;
                case 2:
                    listarRutaTrabajo();
                    break;

                case 3:
                    informacionDetallada();
                    break;

                case 7:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");Escribi
                    break;
            }
        } while (opcion != 7);


    }

    private static void asignarRutaTrabajo() {
        System.out.println("Indicar ruta de trabajo");
        String rutaTrabajo = scanner.nextLine();
        g1.setRutaTrabajo(rutaTrabajo);
        System.out.println(g1.getRutaTrabajo());

    }

    private static void listarRutaTrabajo() {
        File ruta = new File(g1.getRutaTrabajo());
        File[] lista = ruta.listFiles();
        System.out.println("Los archivos y/o carpetas que contiene " + ruta);
        if (lista != null) {
            for (File f : lista) {
                System.out.println("\t" + f + (f.isFile() ? " - fichero" : " - directorio"));
            }
        }

    }

    private static void informacionDetallada() {
        System.out.println("Indica el archivo/carpeta que deseas obtener la información");
        String info = scanner.nextLine();

        File archivo = new File(info);
        long milisegundos = archivo.lastModified();

        // Crear un objeto Date a partir de los milisegundos
        Date fechaModificacion = new Date(milisegundos);

        // Crear un formato de fecha con el patrón deseado y la localización apropiada
        SimpleDateFormat formatoFecha = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);


        if (archivo.exists()) {
            System.out.println("3.- Archivo sobre el que quieres información: " + archivo.getName());
            System.out.println("INFORMACION DEL SISTEMA\n");
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Tipo: " + (archivo.isFile() ? " - archivo" : " - directorio"));
            System.out.println("Longitud: " + archivo.length());
            System.out.println("Ubicación: " + archivo.getAbsolutePath());
            System.out.println("Última modificación: " + formatoFecha.format(fechaModificacion));
            System.out.println("Oculto" + (archivo.isHidden() ? " Si" : " No"));
        } else System.out.println("El archivo/carpeta no existe");


    }

}

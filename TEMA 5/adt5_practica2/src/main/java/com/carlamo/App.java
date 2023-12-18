package com.carlamo;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.security.auth.login.Configuration;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;


        while (!salir) {

            menu();

            String opcion = entrada.nextLine();

            switch (opcion) {

                case "1":
                    insert();
                    break;

                case "2":
                    update();
                    break;

                case "3":
                    delete(2);
                    break;

                case "4":
                    search();
                    break;

                case "5":
                    crearAsistenciaMedica();
                    break;

                case "6":
                    consultas();
                    break;

                case "7":
                    salir = true;
                    System.out.println("Saliendo del programa");
                    break;

            }


        }

    }

    public static void menu() {
        System.out.println("==========================================================");
        System.out.println("========================== MENÚ ==========================");
        System.out.println("1.- Ejercicio1 - Insertar en la entidad Seguro.");
        System.out.println("2.- Ejercicio1 - Actualizar en la entidad Seguro.");
        System.out.println("3.- Ejercicio1 - Borrar en la entidad Seguro.");
        System.out.println("4.- Ejercicio1 - Leer de la entidad Seguro.");
        System.out.println("5.- Ejercicio2 - Creación entidad AsistenciaMedica.");
        System.out.println("6.- Ejercicio3 - Consultas a la base de datos.");
        System.out.println("7.- Salir.");
        System.out.println("==========================================================");
        System.out.print("Opción? ");
    }

    public static void insert() {
        Session session = null;
        session = HibernateUtil.getSession();


        Seguro seg = new Seguro();
        seg.setIdSeguro(3);
        seg.setNif("11111111A");
        seg.setNombre("Pepe");
        seg.setApe1("Palote");
        seg.setApe2("Perico");
        seg.setEdad(30);
        seg.setNumHijos(3);
        seg.setFechaCreacion(LocalDate.now());

        session.beginTransaction();
        session.persist(seg);
        session.getTransaction().commit();
        session.close();

    }

    public static void update() {

        Session session2 = null;
        session2 = HibernateUtil.getSession();


        Seguro seg2 = new Seguro();
        seg2.setIdSeguro(2);
        seg2.setNif("11111111A");
        seg2.setNombre("Juanito");
        seg2.setApe1("Banana");
        seg2.setApe2("Mortadela");
        seg2.setEdad(19);
        seg2.setNumHijos(0);
        seg2.setFechaCreacion(LocalDate.now());

        session2.beginTransaction();
        session2.merge(seg2);
        session2.getTransaction().commit();
        session2.close();


    }

    public static void delete(int id) {

        Session session3 = null;
        session3 = HibernateUtil.getSession();

        Seguro seg3 = new Seguro();
        if (seg3.getIdSeguro() == id) {
            session3.beginTransaction();
            session3.remove(seg3);
            session3.getTransaction().commit();
            session3.close();
        }
    }

    public static void search() {

        Session session4 = null;
        session4 = HibernateUtil.getSession();

        Query<Seguro> query = session4.createQuery("FROM Seguro", Seguro.class);

        List<Seguro> listaClientes = query.list();

        for (Seguro s : listaClientes) {
            System.out.println("==============================================================");

            System.out.println(s);

            System.out.println("==============================================================");

        }

        session4.close();

    }

    public static void crearAsistenciaMedica() {

        Session session = null;
        session = HibernateUtil.getSession();

        Seguro seguro =
                new Seguro(4, "12345678Z", "Juan", "Cháfer", "Bellver", 66, 3, LocalDate.now());
        AsistenciaMedica asistenciaMedica1 =
                new AsistenciaMedica(1, "Médico de cabecera", "Mislata",800.00, seguro);
        AsistenciaMedica asistenciaMedica2 =
                new AsistenciaMedica(2, "Operación de bypass", "Sevilla",4500.00, seguro);

        Seguro seguro5_2 =
                new Seguro(654, "48573562T", "Amparo", "Martí", "López", 26, 0, LocalDate.now());
        AsistenciaMedica asistenciaMedica3 =
                new AsistenciaMedica(3, "Médico de cabecera", "Valencia", 700.00, seguro5_2);
        AsistenciaMedica asistenciaMedica4 =
                new AsistenciaMedica(4, "Operación de miopía", "Valencia", 4500.00, seguro5_2);
        AsistenciaMedica asistenciaMedica5 =
                new AsistenciaMedica(5, "Operación estética", "Madrid", 14500.00, seguro5_2);

        session.beginTransaction();
        session.persist(asistenciaMedica1);
        session.persist(asistenciaMedica2);
        session.persist(asistenciaMedica3);
        session.persist(asistenciaMedica4);
        session.persist(asistenciaMedica5);
        session.getTransaction().commit();
        session.close();


    }

    public static void consultas() {

        System.out.println("1ª consulta. Todos los seguros que hay en la BD");

        Session session = null;
        session = HibernateUtil.getSession();

        Query<Seguro> query = session.createQuery("FROM Seguro", Seguro.class);

        List<Seguro> listaClientes = query.list();

        for (Seguro s : listaClientes) {
            System.out.println("==============================================================");
            System.out.println(s);
            System.out.println("==============================================================");

        }


        System.out.println("2ª consulta. Retorna el NIF y el Nombre de los seguros");


        Query<Object[]> query2 = session.createQuery("SELECT nif, nombre, FROM Seguro", Object[].class);

        List<Object[]> listaSeguros = query2.list();

        for (Object[] resultado: listaSeguros) {
            System.out.println("==============================================================");
            System.out.println("NIF: " + resultado[0] + "Nombre: " + resultado[1]);
            System.out.println("==============================================================");

        }

        System.out.println("3ª consulta. Retorna solo el NIF de un nombre concreto.");

        String nombre3 = "Juan";
        String ape1 = "Chafer";
        String ape2 = "Bellver";

        Query<String> query3 = session.createQuery("SELECT nif FROM Seguro AS s" + "WHERE s.nombre = :nombre AND  s.ape1 = :ape1 AND s.ape2 = :ape2",  String.class);

        query3.setParameter("nombre", nombre3);
        query3.setParameter("ape1", ape1);
        query3.setParameter("ape2", ape2);
        String resultado6_3 = query3.uniqueResult();

        System.out.println("NIF: " + resultado6_3);

        System.out.println("4ª consulta. idAsistencia Médica con importe entre 2000 y 5000 €");



        Query query4 = session.createQuery("FROM AsistenciaMedica a WHERE a.importe > ?1 AND a.importe < ?2", AsistenciaMedica.class);
        query4.setParameter( 1, 2000);
        query4.setParameter(2, 5000);

        List<AsistenciaMedica> a = query4.list();


    }



}
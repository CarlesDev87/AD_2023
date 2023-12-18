package com.carlamo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

// Crear una nueva sesión de Hibernate

        Session session = HibernateUtil.getSession();

        User user = new User();

        user.setNombre("Pepito");
        user.setMensaje("La figa sa mare");

        // Iniciar una transacción
        session.beginTransaction();

// Guardar el user1 en la base de datos
        session.persist(user); // --> save antiguamente
        //.merge  --> update antiguamente
        //.remove --> delete antiguamente

// Commit de la transacción
        session.getTransaction().commit();

// Cerrar la sesión
        session.close();
        HibernateUtil.closeSessionFactory();

    }
}

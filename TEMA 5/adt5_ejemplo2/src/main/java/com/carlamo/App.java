package com.carlamo;

import org.hibernate.Session;


public class App 
{
    public static void main( String[] args )
    {
        Personaje personaje1 = new Personaje("Mario Bros", 100, 110);
        Arma arma1 = new Arma("Fusil", "AK45", 100);

        personaje1.setArma(arma1);
        arma1.setPersonaje(personaje1);

        // Da de alta el objeto en la tabla de datos
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(personaje1);
        //session.persist(arma1);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}

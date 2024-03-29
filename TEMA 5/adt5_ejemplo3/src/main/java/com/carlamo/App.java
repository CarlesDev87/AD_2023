package com.carlamo;

import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        // Creamos los objetos de personaje y arma
        Arma arma1 = new Arma("Fusil", "AK45", 100);

        /* Opción 1 */
		/*
		List<Personaje> listaPersonajes = new ArrayList<Personaje>();
		listaPersonajes.add(new Personaje("Mario", 100, 110));
		listaPersonajes.add(new Personaje("Luigi", 100, 110));
		listaPersonajes.add(new Personaje("Yoshi", 100, 110));
		listaPersonajes.add(new Personaje("Waluigi", 100, 110));

		arma1.setPersonajes(listaPersonajes);
		*/

        /* Opción 2 */
        Personaje personaje1 = new Personaje("Mario", 100, 110);
        Personaje personaje2 = new Personaje("Luigi", 100, 110);
        personaje1.setArma(arma1);
        personaje2.setArma(arma1);

        // Da de alta el objeto en la tabla de datos
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        /* Opción 1 */
        // session.persist(arma1);

        /* Opción 2 */
        session.persist(personaje1);
        session.persist(personaje2);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}

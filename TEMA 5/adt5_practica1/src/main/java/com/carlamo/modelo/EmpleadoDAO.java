package com.carlamo.modelo;


import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements InterfaceDAO {


    public EmpleadoDAO() {


    }
    @Override
    public int insert(Object obj) {

        int numFAfectadas = 1;
        Session session = null;
        session = HibernateUtil.getSession();

        Empleado e = (Empleado) obj;
        session.beginTransaction();
        session.persist(e);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }

    @Override
    public int delete(Object obj) {

        int numFAfectadas = 1;
        Session session = null;
        session = HibernateUtil.getSession();
        Empleado e = (Empleado) obj;
        session.beginTransaction();
        session.remove(e);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }


    @Override
    public ArrayList getAll() {
        Session session = null;
        session = HibernateUtil.getSession();
        Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> listaEmpleados = query.list();
        session.close();


        return (ArrayList) listaEmpleados;
    }


}

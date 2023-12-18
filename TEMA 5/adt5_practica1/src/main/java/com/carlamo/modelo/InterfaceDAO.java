package com.carlamo.modelo;

import java.util.ArrayList;

public interface InterfaceDAO {

 //HAY QUE MANTENER LOS METODOS DE LA INTERFAZ ADAPTANDOLOS A HIBERNATE
 public int insert(Object obj);

    public int delete(Object obj);

    public ArrayList getAll();

}

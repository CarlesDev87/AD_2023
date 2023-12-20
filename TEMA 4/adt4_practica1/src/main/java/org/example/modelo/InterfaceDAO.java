package org.example.modelo;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceDAO {

    public int insert (Object obj);
    public int delete (Object obj);
    public Object search (Object obj) throws SQLException;
    public ArrayList getAll();
    public ArrayList getAllByName(Object obj);
}

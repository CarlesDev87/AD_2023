package modelo;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class ArticuloDAO implements InterfaceDAO {

    private Connection accesoBD = null;

    public ArticuloDAO() {
        accesoBD = GestionBD.getConexion();
    }

    @Override
    public int insert(Object obj) {
        Articulo a = (Articulo) obj;
        int numFAfectadas = 0;

        try {
            String sql = "INSERT INTO articulos VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ps.setString(1, a.getId());
            ps.setString(2, a.getNombre());
            ps.setFloat(3, a.getPrecio());
            ps.setInt(4, a.getStock());
            ps.setString(5, a.getImagen());
            ps.setString(6, a.getDescripcion());

            numFAfectadas = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - add: " + e.getMessage());
        }
        return numFAfectadas;
    }

    @Override
    public int update(Object obj) {
        Articulo a = (Articulo) obj;

        String sql = "UPDATE articulos" +
                "SET nombre=?, precio=?, stock=?, imagen=?, descripcion=?" +
                "WHERE id=?;";

        return 0;
    }

    @Override
    public int delete(Object obj) {
        Articulo a = (Articulo) obj;
        int numFAfectadas = 0;

        try {
            String sql = "DELETE FROM articulos WHERE id= ?;";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ps.setString(1, a.getId());

            numFAfectadas = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - add: " + e.getMessage());
        }
        return numFAfectadas;
    }

    @Override
    public Object search(Object obj) {          // buscar un objeto en concreto en la BD

        Articulo a = (Articulo) obj;

        try {
            String sql = "SELECT * FROM articulos where id=?;";
            PreparedStatement sentencia = accesoBD.prepareStatement(sql);
            sentencia.setString(1, a.getId());

            ResultSet filas = sentencia.executeQuery(sql);

            while (filas.next()) {
                a = new Articulo();
                a.setId(filas.getString("id"));
                a.setNombre(filas.getString("Nombre"));
                a.setPrecio(filas.getFloat("Precio"));
                a.setStock(filas.getInt("Stock"));
                a.setImagen(filas.getString("Imagen"));
                a.setDescripcion(filas.getString("Descripcion"));

            }


        } catch (SQLException e) {
            System.err.println("SQL Select Error: " + e.getMessage());
        }

        return a;
    }

    @Override
    public ArrayList getAll() {         // obtener un arraylist de objetos de la tabla

        ArrayList<Object> elementos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM articulos";
            PreparedStatement ps = accesoBD.prepareStatement(sql);

            ResultSet filas = ps.executeQuery(sql);

            while (filas.next()) {
                elementos.add(ps);
            }

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());

        }

        return elementos;
    }

    @Override
    public ArrayList getAllByName(Object obj) {             //obtener todos los objetos con un nombre concreto
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

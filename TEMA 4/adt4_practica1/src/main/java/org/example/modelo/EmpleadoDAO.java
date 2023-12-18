package org.example.modelo;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO implements InterfaceDAO {

    private Connection accesoBD = null;

    public EmpleadoDAO() {
        accesoBD = GestionBD.getConexion();
    }

    @Override
    public int insert(Object obj) {
        Empleado e = (Empleado) obj;
        int numFAfectadas = 0;

        try {
            String sql = "INSERT INTO empleados VALUES(?,?,?,?,?)";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellidos());
            ps.setInt(4, e.getEdad());
            ps.setDouble(5, e.getSalario());

        } catch (SQLException ex) {
            System.out.println("Error EmpleadoDAO -add " + ex.getMessage());
        }
        return numFAfectadas;
    }

    @Override
    public int delete(Object obj) {
        Empleado e = (Empleado) obj;
        int numFAfectadas = 0;

        try {
            String sql = "DELETE FROM empleados WHERE dni= ?;";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ps.setString(1, e.getDni());

        } catch (SQLException ex) {
            System.out.println("Error empleadoDAO -delete " + ex.getMessage());
        }

        return numFAfectadas;
    }

    @Override
    public Object search(Object obj) {
        Empleado e = (Empleado) obj;
        try {
            String sql = "SELECT FROM empleados WHERE dni= ?;";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ps.setString(1, e.getDni());

            ResultSet filas = ps.executeQuery(sql);

            while(filas.next()) {
                e = new Empleado();
                e.setDni(filas.getString("DNI: "));
                e.setNombre(filas.getString("Nombre: "));
                e.setApellidos(filas.getString("Apellidos: "));
                e.setEdad(filas.getInt("Edad: "));
                e.setSalario(filas.getDouble("Salario: "));
            }

        } catch (SQLException ex) {
            System.out.println("Error EmpleadoDAO -select" + ex.getMessage());
        }

        return e;
    }

    @Override
    public ArrayList getAll() {

        ArrayList<Object> empleados = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empleados";
            PreparedStatement ps = accesoBD.prepareStatement(sql);
            ResultSet filas = ps.executeQuery(sql);

            while(filas.next()) {
                empleados.add(ps);
            }
        } catch (SQLException e) {
            System.out.println("Error empleadoDAO -SelectAll" + e.getMessage());
        }
        return empleados;
    }

    @Override
    public ArrayList getAllByName(Object obj) {
        return null;
    }
}

package com.carlamo;

import com.carlamo.controlador.ControladorEmpleado;
import com.carlamo.modelo.EmpleadoDAO;
import com.carlamo.vista.JFEmpleados;


public class App 
{
    public static void main( String[] args )
    {
        JFEmpleados vista = new JFEmpleados();
        EmpleadoDAO modelo = new EmpleadoDAO();

        ControladorEmpleado ce = new ControladorEmpleado(vista, modelo);

        // Centrar en el centro de la pantalla

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}

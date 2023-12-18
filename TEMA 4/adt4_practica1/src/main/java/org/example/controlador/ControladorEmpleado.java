package org.example.controlador;

import org.example.modelo.Empleado;
import org.example.modelo.EmpleadoDAO;
import org.example.vista.GestionEmpleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ControladorEmpleado implements ActionListener, KeyListener {

    private GestionEmpleado vista;
    private EmpleadoDAO modelo;

    public ControladorEmpleado(GestionEmpleado vistaEmpleado, EmpleadoDAO modeloEmpleado) {

        this.vista = vistaEmpleado;
        this.modelo = modeloEmpleado;

        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
        this.vista.btnListar.addActionListener(this);

        inicializarVista();

    }

    public void inicializarVista() {
        limpiarElementos();
        llenarTabla(vista.tablaEmpleados);
    }


    public void limpiarElementos() {
        vista.textField1.setText("");
        vista.textField2.setText("");
        vista.textField3.setText("");
        vista.textField4.setText("");
        vista.textField5.setText("");
        vista.btnInsertar.setEnabled(true);
        vista.btnBorrar.setEnabled(true);
        vista.btnListar.setEnabled(true);

    }

    public void llenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        modeloT.addColumn("DNI");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("APELLIDOS");
        modeloT.addColumn("EDAD");
        modeloT.addColumn("SALARIO");

        Object[] columna = new Object[5];

        ArrayList lista = modelo.getAll();
        int numeroRegistros = lista.size();

        for (int i = 0; i < numeroRegistros; i++) {
            Empleado e = (Empleado) lista.get(i);
            columna[0] = e.getDni();
            columna[1] = e.getNombre();
            columna[2] = e.getApellidos();
            columna[3] = e.getEdad();
            columna[4] = e.getSalario();

            modeloT.addRow(columna);
        }

        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaD.getTableHeader().setReorderingAllowed(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

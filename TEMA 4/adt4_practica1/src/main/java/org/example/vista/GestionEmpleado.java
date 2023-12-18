package org.example.vista;

import javax.swing.*;

public class GestionEmpleado extends JFrame {
    private JPanel panelPrincipal;
    private JPanel paneIzquierda;
    private JPanel panelDerecha;
    private JPanel paneInferior;
    public JButton btnInsertar;
    public JButton btnBorrar;
    public JButton btnListar;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    public JTable tablaEmpleados;

    public GestionEmpleado() {
        setContentPane(panelPrincipal);
        setTitle("ADT4 práctica 1");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }




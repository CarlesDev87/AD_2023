package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App7 extends JFrame{
    private JTextField txtPalabra;
    private JButton btnAgregar;
    private JButton btnCopiar;
    private JList lstPalabras;
    private JButton btnEliminar;
    private JComboBox cbPalabras;
    private JPanel pnPrincipal;

    private DefaultListModel modelo;

    public App7() {

        modelo = new DefaultListModel();
        lstPalabras.setModel(modelo);
        setSize(900, 600);
        setTitle("ADT$ EJemploe 3 - App6");
        setContentPane(pnPrincipal);
        setVisible(true);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = txtPalabra.getText();
                cbPalabras.addItem(palabra);
            }
        });

        btnCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraSeleccionada = (String) cbPalabras.getSelectedItem();

                modelo.addElement(palabraSeleccionada);
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraSeleccionada = (String) cbPalabras.getSelectedItem();
                modelo.removeElement(lstPalabras.getSelectedIndex());

            }
        });


    }

    public static void main(String[] args) {
        new App7();



    }
}



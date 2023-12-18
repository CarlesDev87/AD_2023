package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App8 extends JFrame{
    private JPanel pnPrincipal;
    private JLabel lbApp;
    private JLabel lbEnunciado;
    private JButton btnMostrar;
    private JButton btnVaciar;
    private JTable jtDatos;
    private JLabel lbTabla;

    public App8() {



        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = new DefaultTableModel();
                jtDatos.setModel(model);                // Asignamos el modelo a la JTable

                model.addColumn("Nombre");
                model.addColumn("Apellidos");
                model.addColumn("Edad");


                Object [] columna = new Object[3];

                columna[0] = "Pepe";
                columna[1] = "Palote";
                columna[2] = "35";

                model.addRow(columna);





            }
        });
        btnVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelV = new DefaultTableModel();
                jtDatos.setModel(modelV);

            }
        });
    }

    public static void main(String[] args) {
       App8 ventana= new App8();

        ventana.setContentPane(ventana.pnPrincipal);
        ventana.setTitle("Ejemplo 8");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }
}

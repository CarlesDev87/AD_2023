package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App6 extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JButton btnEntrar;
    private JPanel pnPrincipal;

    public App6() {
        setTitle("Aplicación 6");
        setContentPane(pnPrincipal);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setLocationRelativeTo(null); // CENTRARA EL JFRAME EN MITAD DE LA PANTALLA
        setVisible(true);
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pulsado");
                JOptionPane.showMessageDialog(null, "Pulsado"); //Ventana de dialogo
            }
        });
    }

    public static void main(String[] args) {
        new App6();
    }


}

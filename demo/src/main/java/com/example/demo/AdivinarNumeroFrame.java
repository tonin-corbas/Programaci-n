package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class AdivinarNumeroFrame extends JFrame {
    private JTextField textField;
    private JButton button;
    private JLabel label;
    private int numeroSecreto;
    private int intentos;

    public AdivinarNumeroFrame() {
        setTitle("Adivinar el número");
        setSize(300, 200);
        setLayout(new FlowLayout());

        numeroSecreto = new Random().nextInt(100) + 1;
        intentos = 7;

        label = new JLabel("Introduce un número entre 1 y 100. Tienes 7 intentos.");
        add(label);

        textField = new JTextField(10);
        add(textField);

        button = new JButton("Comprobar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroUsuario = Integer.parseInt(textField.getText());
                    if (numeroUsuario == numeroSecreto) {
                        JOptionPane.showMessageDialog(null, "¡Has acertado el número!");
                        System.exit(0);
                    } else {
                        intentos--;
                        if (intentos == 0) {
                            JOptionPane.showMessageDialog(null, "Has agotado tus intentos. El número era " + numeroSecreto);
                            System.exit(0);
                        } else {
                            String mensaje = numeroUsuario < numeroSecreto ? "El número secreto es mayor. " : "El número secreto es menor. ";
                            mensaje += "Te quedan " + intentos + " intentos.";
                            JOptionPane.showMessageDialog(null, mensaje);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
                }
            }
        });
        add(button);
    }
}
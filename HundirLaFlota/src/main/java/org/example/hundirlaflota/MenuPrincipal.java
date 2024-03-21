package org.example.hundirlaflota;
import javax.swing.*;

class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        JButton botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(e -> {
            new HundirFlotaJuego();
            this.dispose();
        });

        this.add(botonJugar);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
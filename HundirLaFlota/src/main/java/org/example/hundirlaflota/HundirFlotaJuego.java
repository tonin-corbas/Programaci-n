package org.example.hundirlaflota;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class HundirFlotaJuego extends JFrame {
    private Casilla[][] casillas = new Casilla[5][5];
    private int barcosRestantes = 5;
    private int intentosRestantes = 20;
    private JLabel infoLabel;

    public HundirFlotaJuego() {
        this.setLayout(new BorderLayout());
        JPanel panelTablero = new JPanel(new GridLayout(5, 5));
        infoLabel = new JLabel();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                casillas[i][j] = new Casilla(this);
                panelTablero.add(casillas[i][j]);
            }
        }

        colocarBarcosAleatoriamente();

        this.add(panelTablero, BorderLayout.CENTER);
        this.add(infoLabel, BorderLayout.SOUTH);
        actualizarInfoLabel();

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void colocarBarcosAleatoriamente() {
        Random rand = new Random();
        int i = 0;
        while (i < barcosRestantes) {
            int x = rand.nextInt(5);
            int y = rand.nextInt(5);
            if (!casillas[x][y].conBarco) {
                casillas[x][y].conBarco = true;
                i++;
            }
        }
    }

    public void actualizarInfoLabel() {
        infoLabel.setText("Barcos restantes: " + barcosRestantes + " Intentos restantes: " + intentosRestantes);
    }

    public void decrementarBarcosRestantes() {
        barcosRestantes--;
    }

    public void decrementarIntentosRestantes() {
        intentosRestantes--;
    }

    public int getBarcosRestantes() {
        return barcosRestantes;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }
}
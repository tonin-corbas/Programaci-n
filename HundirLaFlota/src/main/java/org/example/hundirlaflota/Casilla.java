package org.example.hundirlaflota;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Casilla extends JButton {
    boolean conBarco = false;
    HundirFlotaJuego juego;

    public Casilla(HundirFlotaJuego juego) {
        this.juego = juego;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (conBarco) {
                    setBackground(Color.RED);
                    juego.decrementarBarcosRestantes();
                } else {
                    setBackground(Color.BLUE);
                }
                setEnabled(false);
                juego.decrementarIntentosRestantes();
                juego.actualizarInfoLabel();

                if (juego.getBarcosRestantes() == 0) {
                    JOptionPane.showMessageDialog(null, "¡Has ganado!");
                    juego.dispose();
                    new MenuPrincipal();
                } else if (juego.getIntentosRestantes() == 0) {
                    JOptionPane.showMessageDialog(null, "¡Has perdido!");
                    juego.dispose();
                    new MenuPrincipal();
                }
            }
        });
    }
}

package Controladores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private JFrame frame;
    private JPanel panel;
    private JButton viewGamesButton;
    private JButton viewTop10Button;
    private JButton viewAddCharacterButton;

    public MainController() {
        frame = new JFrame("Proyecto Final");
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        viewGamesButton = new JButton("Ver Juegos y Épocas");
        viewTop10Button = new JButton("Ver Top 10 de Personajes");
        viewAddCharacterButton = new JButton("Agregar Personaje");

        viewGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewGames();
            }
        });

        viewTop10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTop10();
            }
        });

        panel.add(viewGamesButton);
        panel.add(viewTop10Button);
        panel.add(viewAddCharacterButton);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void viewGames() {
        new GameDetailsController();
    }

    private void viewTop10() {
        new Top10Controller();
    }
}

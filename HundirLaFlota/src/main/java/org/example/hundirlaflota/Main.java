package org.example.hundirlaflota;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal();
        });
    }
}
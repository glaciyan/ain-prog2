// O. Bittel
// 10.03.2017

package de.ketra.aufgabe10;

import javax.swing.*;
import java.awt.*;

public class TelefonBuchGUI extends JFrame {

    private static Window mainWindow;

    TelefonBuchEinfuegenPanel einfuegenPanel;
    TelefonBuchSuchenLoeschenPanel suchenLoeschenPanel;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        TelefonBuch telBuch = new TelefonBuch();

        // Menuleiste einbauen:
        this.setJMenuBar(new TelefonBuchMenuBar(telBuch));

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BorderLayout());
        // ...
        this.setContentPane(mainPanel);

        einfuegenPanel = new TelefonBuchEinfuegenPanel(telBuch);
        mainPanel.add(einfuegenPanel, BorderLayout.NORTH);
        suchenLoeschenPanel = new TelefonBuchSuchenLoeschenPanel(telBuch);
        mainPanel.add(suchenLoeschenPanel, BorderLayout.CENTER);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        this.addWindowListener(new ClosingHandler());
    }

    public static void main(String[] args) {
        mainWindow = new TelefonBuchGUI();
    }

    public static void confirmCloseMainWindow() {
        int n = JOptionPane.showConfirmDialog(mainWindow, "Wollen sie sicher das Programm verlassen?\nDas Telefonbuch wird nicht gespeichert.", "Confirm Exit", JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            mainWindow.dispose();
            System.exit(0);
        }
    }
}

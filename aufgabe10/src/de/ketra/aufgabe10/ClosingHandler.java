package de.ketra.aufgabe10;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosingHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        TelefonBuchGUI.confirmCloseMainWindow();
    }
}

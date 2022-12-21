// O. Bittel
// 10.03.2017

package de.ketra.aufgabe10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static de.ketra.aufgabe10.TelefonBuchGUI.confirmCloseMainWindow;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private final TelefonBuch telBuch;
    private final JMenuItem loadFile;
    private final JMenuItem saveFile;
    private final JMenuItem close;
    private final JFileChooser fc;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;

        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JMenu menu = new JMenu("Datei");

        loadFile = new JMenuItem("Telefonbuch lesen...");
        loadFile.addActionListener(this);
        menu.add(loadFile);

        saveFile = new JMenuItem("Telefonbuch speichern...");
        saveFile.addActionListener(this);
        menu.add(saveFile);

        menu.addSeparator();

        close = new JMenuItem("Telefonbuch beenden");
        close.addActionListener(this);
        menu.add(close);

        this.add(menu);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loadFile) {
            int status = fc.showOpenDialog(this);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                telBuch.read(file);
            }
        } else if (source == saveFile) {
            int status = fc.showSaveDialog(this);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                telBuch.save(file);
            }
        } else if (source == close) {
            confirmCloseMainWindow();
        }
    }
}


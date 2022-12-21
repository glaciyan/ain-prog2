// O. Bittel
// 10.03.2017

package de.ketra.aufgabe10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelefonBuchSuchenLoeschenPanel
        extends JPanel implements ActionListener {
    private static final String[] SuchOptionen = {"Exakte Suche", "Prefix-Suche", "Löschen"};

    private final TelefonBuch telBuch;
    private final JTextField tfSucheName;
    private final JTextField tfSucheZusatz;
    private final JComboBox<String> tfSucheModus;
    private final JTextArea outputField;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
        this.telBuch = tb;


        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(new JLabel("Name"));
        tfSucheName = new JTextField("", 20);
        panel1.add(tfSucheName);
        panel1.add(new JLabel("Zusatz"));
        tfSucheZusatz = new JTextField("", 20);
        panel1.add(tfSucheZusatz);

        JPanel search = new JPanel();
        Border border = BorderFactory.createTitledBorder("Suchen/Löschen");
        search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
        search.setBorder(border);
        search.add(panel1);


        tfSucheModus = new JComboBox<>(SuchOptionen);
        search.add(tfSucheModus);

        JButton anwendenButton = new JButton("Anwenden");
        anwendenButton.addActionListener(this);
        search.add(anwendenButton);

        this.setLayout(new BorderLayout());
        this.add(search, BorderLayout.NORTH);

        outputField = new JTextArea(15, 20);
        outputField.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputField);

        Border border1 = BorderFactory.createTitledBorder("Ausgabe");
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(scroll);
        panel2.setBorder(border1);

        this.add(panel2, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfSucheName.getText().trim();
        String zusatz = tfSucheZusatz.getText().trim();

        if (name.length() != 0) {
            if (tfSucheModus.getSelectedItem() instanceof String str) {
                switch (str) {
                    case "Exakte Suche" -> {
                        var result = telBuch.exactSearch(name, zusatz);
                        if (result == null) {
                            JOptionPane.showMessageDialog(this, "Keine ergebnisse gefunden!");
                            break;
                        }
                        outputField.setText(result);
                    }
                    case "Prefix-Suche" -> prefixSuche(name, zusatz);
                    case "Löschen" -> {
                        var success = telBuch.remove(name, zusatz);
                        if (!success) {
                            JOptionPane.showMessageDialog(this, "Der Name wurde nicht gefunden und konnte nicht gelöscht werden.");
                        } else {
                            JOptionPane.showMessageDialog(this, (name + " " + zusatz).trim() + " wurde entfernt!");
                        }
                    }
                }
            }
        } else if (tfSucheModus.getSelectedItem() instanceof String str && str.equals("Prefix-Suche")) {
            prefixSuche("", "");
        } else {
            JOptionPane.showMessageDialog(this, "Name wird benötigt");
        }
    }

    private void prefixSuche(String name, String zusatz) {
        var suchErgebnis = telBuch.prefixSearch((name + " " + zusatz).trim());
        if (suchErgebnis.size() == 0) {
            JOptionPane.showMessageDialog(this, "Keine ergebnisse gefunden!");
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (var person : suchErgebnis) {
            builder.append(person).append('\n');
        }
        outputField.setText(builder.toString());
    }
}

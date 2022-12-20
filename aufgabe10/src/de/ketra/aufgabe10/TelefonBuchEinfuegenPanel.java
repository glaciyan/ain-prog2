// O. Bittel
// 10.03.2017

package de.ketra.aufgabe10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    private final TelefonBuch telBuch;
    private final JTextField tfEinfuegenName;
    private final JTextField tfEinfuegenZusatz;
    private final JTextField tfEinfuegenTelNr;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));
        panel1.add(new JLabel("TelefonNummer"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfügen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        JButton buttonEinfuegen = new JButton("Einfügen");
        this.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfEinfuegenName.getText();
        String zusatz = tfEinfuegenZusatz.getText();
        String telNr = tfEinfuegenTelNr.getText();

        if (name.length() != 0 && telNr.length() != 0) {
            var success = telBuch.insert(name, zusatz, telNr);
            if (!success) {
                JOptionPane.showMessageDialog(this, "Der eintrag existiert schon.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name und Telefonnummer sind benötigt.");
        }
    }
}

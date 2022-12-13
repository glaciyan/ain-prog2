import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Rechner extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton clearButton;
    private JRadioButton degRadioButton;
    private JRadioButton radRadioButton;
    private JCheckBox whiteThemeCheckBox;
    private JButton plusButton;
    private JButton mulButton;
    private JButton minusButton;
    private JButton sinButton;
    private JButton cosButton;
    private JButton potenzButton;
    private JTextField opX;
    private JTextField opY;
    private JTextField resultField;
    private JButton divButton;
    private JButton log2Button;
    private JPanel buttonPanel;

    private static final Theme white = new Theme(Color.WHITE, Color.BLACK);
    private static final Theme dark = new Theme(Color.BLACK, Color.YELLOW);

    private Theme current = white;

    private DegreeMode mode = DegreeMode.Degree;

    private Object lastEmitter;

    public Rechner() {
        this.setContentPane(contentPane);
        this.setTitle("Rechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        whiteThemeCheckBox.setSelected(true);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(degRadioButton);
        radioGroup.add(radRadioButton);
        degRadioButton.setSelected(true);

        resultField.setEditable(false);

        var comps = new ArrayList<>(List.of(buttonPanel.getComponents()));
        comps.add(radRadioButton);
        comps.add(degRadioButton);
        comps.add(whiteThemeCheckBox);
        comps.add(clearButton);
        for (Component comp : comps) {
            if (comp instanceof AbstractButton button) {
                button.addActionListener(this);
            }
        }

        clear();
    }

    private void applyTheme() {
        opX.setBackground(current.background());
        opX.setForeground(current.foreground());
        opY.setBackground(current.background());
        opY.setForeground(current.foreground());
        resultField.setBackground(current.background());
        resultField.setForeground(current.foreground());
    }

    public void setTheme(Theme theme) {
        this.current = theme;
        applyTheme();
    }

    private void clear() {
        opX.setText("0");
        opY.setText("0");
        resultField.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == degRadioButton) {
            degRadioButton.setSelected(true);
            mode = DegreeMode.Degree;

            if (lastEmitter == sinButton) {
                sinButton.doClick();
            } else if (lastEmitter == cosButton) {
                cosButton.doClick();
            }

            return;
        } else if (source == radRadioButton) {
            radRadioButton.setSelected(true);
            mode = DegreeMode.Radians;

            if (lastEmitter == sinButton) {
                sinButton.doClick();
            } else if (lastEmitter == cosButton) {
                cosButton.doClick();
            }
            return;
        } else if (source == whiteThemeCheckBox) {
            if (whiteThemeCheckBox.isSelected()) {
                setTheme(white);
            } else {
                setTheme(dark);
            }
            return;
        } else if (source == clearButton) {
            clear();
            return;
        }

        try {
            var calc = getCalculation();
            Double result = null;

            if (source == plusButton) {
                result = calc.sum();
            } else if (source == minusButton) {
                result = calc.minus();
            } else if (source == mulButton) {
                result = calc.mul();
            } else if (source == divButton) {
                result = calc.division();
            } else if (source == potenzButton) {
                result = calc.potenz();
            } else if (source == sinButton) {
                opY.setText("0");
                result = calc.sin(mode == DegreeMode.Radians);
            } else if (source == cosButton) {
                opY.setText("0");
                result = calc.cos(mode == DegreeMode.Radians);
            } else if (source == log2Button) {
                opY.setText("0");
                result = calc.log2();
            }

            if (result != null) {
                resultField.setText(String.format(Locale.US, "%f", result));
                applyTheme();
            }

        } catch (Exception err) {
            System.err.println("Error doing calculation.");
        } finally {
            lastEmitter = source;
        }
    }

    private Calculation getCalculation() {
        String xText = opX.getText();
        String yText = opY.getText();

        double x;
        try {
            x = Double.parseDouble(xText);
        } catch (Exception err) {
            opX.setBackground(Color.RED);
            System.err.println(err.getMessage());
            throw err;
        }

        double y;
        try {
            y = Double.parseDouble(yText);
        } catch (Exception err) {
            opY.setBackground(Color.RED);
            System.err.println(err.getMessage());
            throw err;
        }

        return new Calculation(x, y);
    }
}

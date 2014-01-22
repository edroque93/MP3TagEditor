package mp3tageditor.UI.Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mp3tageditor.Control.ActionListenerFactory;

public class OpenFilePanel extends JPanel {

    private ActionListenerFactory factory;
    private JFrame frame;
    private JTextField fileField;
    private JLabel infoLabel;
    private JPanel buggyPanel;

    public OpenFilePanel(JFrame frame, ActionListenerFactory factory) {
        super(new BorderLayout());
        this.frame = frame;
        this.factory = factory;
        createComponents();
    }

    public void setLabelText(String text) {
        infoLabel.setText(text);
        frame.repaint();
    }

    public void setLabelForegroundColor(Color color) {
        infoLabel.setForeground(color);
    }

    public void setFileInField(String fileName) {
        fileField.setText(fileName);
    }

    private void createComponents() {
        add(createFileToolbar(), BorderLayout.NORTH);
        add(createLabelToolbar(), BorderLayout.CENTER);
    }

    private JButton createButton(String open) {
        JButton button = new JButton(open);
        button.addActionListener(factory.getAction(open));
        return button;
    }

    private JTextField createTextField(String file) {
        JTextField field = new JTextField();
        field.setEditable(false);
        field.setPreferredSize(new Dimension(350, 26));
        fileField = field;
        return field;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(16f));
        infoLabel = label;
        return label;
    }

    private JPanel createFileToolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(createTextField("File"));
        panel.add(createButton("Open"));
        return panel;
    }

    private JPanel createLabelToolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(createLabel("Give me a file!"));
        buggyPanel = panel;
        return panel;
    }

}

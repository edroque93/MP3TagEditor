package mp3tageditor.UI.Swing;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mp3tageditor.Control.ActionListenerFactory;

public class OpenFilePanel extends JPanel {

    private ActionListenerFactory factory;
    private JTextField fileField;

    public OpenFilePanel(ActionListenerFactory factory) {
        this.factory = factory;
        createComponents();
    }

    private void createComponents() {
        add(createTextField("File"));
        add(createButton("Open"));
    }

    private JButton createButton(String open) {
        JButton button = new JButton(open);
        button.addActionListener(factory.getAction(open));
        return button;
    }

    private JTextField createTextField(String file) {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(350, 26));
        fileField = field;
        return field;
    }

}

package mp3tageditor.UI.Swing;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import mp3tageditor.Control.ActionListenerFactory;

public class MiscellanyPanel extends JPanel {

    private ActionListenerFactory factory;
    private Box buttonsBox;

    public MiscellanyPanel(ActionListenerFactory factory) {
        this.factory = factory;
        buttonsBox = Box.createVerticalBox();
        createComponents();
    }

    private void createComponents() {
        buttonsBox.add(createButton("Write file"));
        buttonsBox.add(createButton("About"));

        add(buttonsBox);
    }

    private JPanel createButton(String buttonName) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        JButton button = new JButton(buttonName);
        button.addActionListener(factory.getAction(buttonName));
        panel.add(button);
        return panel;
    }

}

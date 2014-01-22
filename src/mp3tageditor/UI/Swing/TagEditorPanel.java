package mp3tageditor.UI.Swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mp3tageditor.Control.ActionListenerFactory;

public class TagEditorPanel extends JPanel {
    
    private ActionListenerFactory factory;
    private Box fieldBox;
    private JTextField title, artist, album, year, comment, genre;

    public TagEditorPanel(ActionListenerFactory factory) {
        this.factory = factory;
        fieldBox = Box.createVerticalBox();        
        createComponents();
    }

    private void createComponents() {
        title = createField("Title");
        artist = createField("Artist");
        album = createField("Album");
        year = createField("Year");
        comment = createField("Comment");
        genre = createField("Genre");
        
        add(fieldBox);
    }

    private JTextField createField(String fieldName) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        JLabel label = new JLabel(fieldName);
        label.setPreferredSize(new Dimension(60, 26));
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(180, 26));
        
        panel.add(label);
        panel.add(textField);
        fieldBox.add(panel);
        
        return textField;
    }

}

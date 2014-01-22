package mp3tageditor.UI.Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mp3tageditor.Control.ActionListenerFactory;

public class MainFrame extends JFrame {

    private ActionListenerFactory factory;
    private OpenFilePanel opeFilePanel;
    private TagEditorPanel tagEditorPanel;

    public MainFrame(ActionListenerFactory factory) {
        super("MP3 Tag Editor");

        this.factory = factory;
        setResizable(false);
        setSize(new Dimension(460, 200));
        setLocationRelativeTo(null);
        createComponents();
        setVisible(true);
    }

    public OpenFilePanel getOpeFilePanel() {
        return opeFilePanel;
    }

    private void createComponents() {
        add(createFilePanel(), BorderLayout.SOUTH); 
        add(createTagEditorPanel(), BorderLayout.WEST);
    }

    private JPanel createFilePanel() {
        OpenFilePanel panel = new OpenFilePanel(factory);
        opeFilePanel = panel;
        return panel;
    }

    private JPanel createTagEditorPanel() {
        TagEditorPanel panel = new TagEditorPanel(factory);
        tagEditorPanel = panel;
        return panel;
    }

}

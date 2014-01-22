package mp3tageditor.UI.Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mp3tageditor.Control.ActionListenerFactory;

public class MainFrame extends JFrame {

    private ActionListenerFactory factory;
    private OpenFilePanel opeFilePanel;
    private TagEditorPanel tagEditorPanel;
    private MiscellanyPanel miscellanyPanel;

    public MainFrame(ActionListenerFactory factory) {
        super("mp3 Tag Editor");

        this.factory = factory;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(createBackground());
        createComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public OpenFilePanel getOpeFilePanel() {
        return opeFilePanel;
    }

    private void createComponents() {
        add(createFilePanel(), BorderLayout.SOUTH);
        add(createTagEditorPanel(), BorderLayout.WEST);
        add(createMiscellanyPanel());
    }

    private JPanel createFilePanel() {
        OpenFilePanel panel = new OpenFilePanel(factory);
        panel.setBackground(new Color(0, 0, 0, 0));
        opeFilePanel = panel;
        return panel;
    }

    private JPanel createTagEditorPanel() {
        TagEditorPanel panel = new TagEditorPanel(factory);
        panel.setBackground(new Color(0, 0, 0, 0));
        tagEditorPanel = panel;
        return panel;
    }

    private JPanel createMiscellanyPanel() {
        MiscellanyPanel panel = new MiscellanyPanel(factory);
        panel.setBackground(new Color(0, 0, 0, 0));
        miscellanyPanel = panel;
        return panel;
    }

    private Container createBackground() {
        try {
            return new BackgroundPanel(
                    ImageIO.read(getClass().getResource("/mp3tageditor/Resources/bg.png")),
                    new BorderLayout());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return null;
    }

}

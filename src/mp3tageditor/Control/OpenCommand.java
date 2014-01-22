package mp3tageditor.Control;

import java.awt.Color;
import java.io.File;
import java.util.Timer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import mp3tageditor.UI.Swing.LabelTimerTask;
import mp3tageditor.UI.Swing.OpenFilePanel;
import mp3tageditor.UI.Swing.TagEditorPanel;

public class OpenCommand extends Command {

    private OpenFilePanel openFilePanel;
    private TagEditorPanel tagEditorPanel;
    private JFrame frame;

    public OpenCommand(JFrame frame, OpenFilePanel openFilePanel, TagEditorPanel tagEditorPanel) {
        this.frame = frame;
        this.openFilePanel = openFilePanel;
        this.tagEditorPanel = tagEditorPanel;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(createFilter());

        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            openFilePanel.setFileInField(file.getAbsolutePath());
            openFilePanel.setLabelForegroundColor(new Color(0x33, 0x99, 0x33));
            openFilePanel.setLabelText("Analyzing mp3 file...");

            TagAnalyzer tagAnalyzer = new TagAnalyzer(tagEditorPanel, file.getAbsolutePath());
            tagAnalyzer.scan();
            openFilePanel.setLabelForegroundColor(new Color(0x33, 0x33, 0x33));
            openFilePanel.setLabelText("Done!");

            createTimerEffect();
        } else {
            openFilePanel.setLabelForegroundColor(Color.red);
            openFilePanel.setLabelText("Something went wrong while choosing :(");
        }
    }

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1)
            ext = s.substring(i + 1).toLowerCase();
        return ext;
    }

    private FileFilter createFilter() {
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory())
                    return true;

                String extension = getExtension(file);

                if (extension != null)
                    if (extension.equals("mp3"))
                        return true;

                return false;
            }

            @Override
            public String getDescription() {
                return "";
            }
        };
    }

    private void createTimerEffect() {
        new Timer().schedule(new LabelTimerTask(
                openFilePanel,
                "Feel free to modify the metadata",
                new Color(0x33, 0x99, 0x33)), 1000);
    }

}

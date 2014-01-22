package mp3tageditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mp3tageditor.Control.AboutCommand;
import mp3tageditor.Control.ActionListenerFactory;
import mp3tageditor.Control.CommandDictionary;
import mp3tageditor.Control.OpenCommand;
import mp3tageditor.Control.WriteCommand;
import mp3tageditor.UI.Swing.MainFrame;

/**
 * @author Quique
 */
public class MP3TagEditor {

    private MainFrame frame;
    private CommandDictionary commandDictionary;

    public static void main(String[] args) {
        new MP3TagEditor().execute();
    }

    private void execute() {
        frame = new MainFrame(new ActionListenerFactory() {

            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commandDictionary.get(action).execute();
                    }
                };
            }
        });

        createCommands();
    }

    private void createCommands() {
        commandDictionary = new CommandDictionary();
        commandDictionary.put("About", new AboutCommand(frame));
        commandDictionary.put("Open", new OpenCommand(
                frame,
                frame.getOpenFilePanel(),
                frame.getTagEditorPanel()));
        commandDictionary.put("Write file", new WriteCommand(
                frame.getTagEditorPanel(),
                frame.getOpenFilePanel()));
    }

}

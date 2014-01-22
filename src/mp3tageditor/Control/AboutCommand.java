package mp3tageditor.Control;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AboutCommand extends Command {

    private JFrame frame;

    public AboutCommand(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void execute() {
        int width = 350;
        String message = "<html><body width='" + width
                + "'><h1>About</h1>"
                +"<p align=\"justify\">This application serves as a mp3 tag "
                + "editor. The mp3 file holds an ID3 container which stores "
                + "metadata about the mp3 song, including: the title, artist, "
                + "album, etc.<br><br>Java powered, designed by ThePirateCat."
                + "</p></html>";

        JOptionPane.showMessageDialog(
                frame,
                message, "About",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("/mp3tageditor/Resources/logo.png")));
    }

}

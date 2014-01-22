package mp3tageditor.UI.Swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.JComponent;

public class BackgroundPanel extends JComponent {

    Image image;

    public BackgroundPanel(Image image, LayoutManager layout) {
        this.image = image;
        setLayout(layout);
    }

    @Override
    public void paintComponent(Graphics graphic) {
        graphic.drawImage(image, 0, 0, null);
    }

}

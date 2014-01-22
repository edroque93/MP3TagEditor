package mp3tageditor.UI.Swing;

import java.awt.Color;
import java.util.TimerTask;

public class LabelTimerTask extends TimerTask {

    private OpenFilePanel openFilePanel;
    private String text;
    private Color color;

    public LabelTimerTask(OpenFilePanel openFilePanel) {
        this.openFilePanel = openFilePanel;
    }

    public LabelTimerTask(OpenFilePanel openFilePanel, String text) {
        this.openFilePanel = openFilePanel;
        this.text = text;
    }

    public LabelTimerTask(OpenFilePanel openFilePanel, String text, Color color) {
        this.openFilePanel = openFilePanel;
        this.text = text;
        this.color = color;
    }

    @Override
    public void run() {
        if (text == null)
            openFilePanel.setLabelText(" ");
        else
            openFilePanel.setLabelText(text);
        
        if (color != null)
            openFilePanel.setLabelForegroundColor(color);
    }

}

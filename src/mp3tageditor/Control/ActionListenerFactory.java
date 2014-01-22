package mp3tageditor.Control;

import java.awt.event.ActionListener;

public interface ActionListenerFactory {
    
    public ActionListener getAction(String action);

}

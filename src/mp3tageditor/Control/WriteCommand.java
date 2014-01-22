package mp3tageditor.Control;

import java.awt.Color;
import java.util.Timer;
import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3v1;
import mp3tageditor.Persistence.SaveFile;
import mp3tageditor.UI.Swing.LabelTimerTask;
import mp3tageditor.UI.Swing.OpenFilePanel;
import mp3tageditor.UI.Swing.TagEditorPanel;

public class WriteCommand extends Command {

    private final TagEditorPanel tagEditorPanel;
    private final OpenFilePanel openFilePanel;

    public WriteCommand(TagEditorPanel tagEditorPanel, OpenFilePanel openFilePanel) {
        this.tagEditorPanel = tagEditorPanel;
        this.openFilePanel = openFilePanel;
    }

    @Override
    public void execute() {
        openFilePanel.setLabelForegroundColor(new Color(0x33, 0x99, 0x33));
        openFilePanel.setLabelText("Writing mp3 file...");
        
      ID3v1 id3v1 = new ID3v1();
        id3v1.setSignature(new ByteHolder("ID3v1", ID3v1.ID3v1_SIGNATURE_SIZE));
        fillID3Structure(id3v1);
        SaveFile.save(openFilePanel.getFilePath(), id3v1);
        
        openFilePanel.setLabelForegroundColor(new Color(0x33, 0x33, 0x33));
        openFilePanel.setLabelText("Done!");
        createTimerToClear();
    }

    private void fillID3Structure(ID3v1 id3v1) {
        id3v1.setTitle(new ByteHolder(tagEditorPanel.getTitle().getText(), ID3v1.ID3v1_TITLE_SIZE));
        id3v1.setArtist(new ByteHolder(tagEditorPanel.getArtist().getText(), ID3v1.ID3v1_ARTIST_SIZE));
        id3v1.setAlbum(new ByteHolder(tagEditorPanel.getAlbum().getText(), ID3v1.ID3v1_ALBUM_SIZE));
        id3v1.setYear(new ByteHolder(tagEditorPanel.getYear().getText(), ID3v1.ID3v1_YEAR_SIZE));
        id3v1.setComment(new ByteHolder(tagEditorPanel.getComment().getText(), ID3v1.ID3v1_COMMENT_SIZE));
        if (!tagEditorPanel.getGenre().getText().isEmpty())
            id3v1.setGenre(new ByteHolder(Byte.parseByte(tagEditorPanel.getGenre().getText())));
    }

    private void createTimerToClear() {
        new Timer().schedule(new LabelTimerTask(openFilePanel), 1000);
    }

}

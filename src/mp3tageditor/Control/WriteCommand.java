package mp3tageditor.Control;

import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3;
import mp3tageditor.Persistence.SaveFile;
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
        ID3 id3 = new ID3();
        id3.setSignature(new ByteHolder("TAG", ID3.ID3_SIGNATURE_SIZE));
        fillID3Structure(id3);
        System.out.println(id3);
        SaveFile.save(openFilePanel.getFilePath(), id3);
    }

    private void fillID3Structure(ID3 id3) {
        id3.setTitle(new ByteHolder(tagEditorPanel.getTitle().getText(), ID3.ID3_TITLE_SIZE));
        id3.setArtist(new ByteHolder(tagEditorPanel.getArtist().getText(), ID3.ID3_ARTIST_SIZE));
        id3.setAlbum(new ByteHolder(tagEditorPanel.getAlbum().getText(), ID3.ID3_ALBUM_SIZE));
        id3.setYear(new ByteHolder(tagEditorPanel.getYear().getText(), ID3.ID3_YEAR_SIZE));
        id3.setComment(new ByteHolder(tagEditorPanel.getComment().getText(), ID3.ID3_COMMENT_SIZE));
        id3.setGenre(new ByteHolder(tagEditorPanel.getGenre().getText(), ID3.ID3_GENRE_SIZE));
    }

}

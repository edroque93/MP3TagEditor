package mp3tageditor.Control;

import mp3tageditor.Model.ID3v1;
import mp3tageditor.Persistence.FileLoader;
import mp3tageditor.UI.Swing.TagEditorPanel;

public class TagAnalyzer {

    private TagEditorPanel tagEditorPanel;
    private String filePath;

    public TagAnalyzer(TagEditorPanel tagEditorPanel, String filePath) {
        this.tagEditorPanel = tagEditorPanel;
        this.filePath = filePath;
    }

    public void scan() {
        ID3v1 id3 = FileLoader.load(filePath);
        tagEditorPanel.getTitle().setText(id3.getTitle().toString());
        tagEditorPanel.getArtist().setText(id3.getArtist().toString());
        tagEditorPanel.getAlbum().setText(id3.getAlbum().toString());
        tagEditorPanel.getYear().setText(id3.getYear().toString());
        tagEditorPanel.getComment().setText(id3.getComment().toString());
        tagEditorPanel.getGenre().setText(String.format("%d", id3.getGenre().getByteFromVector(0)));
    }

}

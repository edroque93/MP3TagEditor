package mp3tageditor.Control;

import mp3tageditor.Model.ID3v1;
import mp3tageditor.Model.ID3v2;
import mp3tageditor.Persistence.FileLoaderID3v1;
import mp3tageditor.Persistence.FileLoaderID3v2;
import mp3tageditor.UI.Swing.TagEditorPanel;

public class TagAnalyzer {

    private TagEditorPanel tagEditorPanel;
    private String filePath;

    public TagAnalyzer(TagEditorPanel tagEditorPanel, String filePath) {
        this.tagEditorPanel = tagEditorPanel;
        this.filePath = filePath;
    }

    public void scanID3v1() {
        FileLoaderID3v1 loader = new FileLoaderID3v1();
        ID3v1 id3 = loader.load(filePath);
        tagEditorPanel.getTitle().setText(id3.getTitle().toString());
        tagEditorPanel.getArtist().setText(id3.getArtist().toString());
        tagEditorPanel.getAlbum().setText(id3.getAlbum().toString());
        tagEditorPanel.getYear().setText(id3.getYear().toString());
        tagEditorPanel.getComment().setText(id3.getComment().toString());
        tagEditorPanel.getGenre().setText(String.format("%d", id3.getGenre().getByteFromVector(0)));
    }

    public void scanID3v2() {
        FileLoaderID3v2 loader = new FileLoaderID3v2();
        ID3v2 id3 = loader.load(filePath);
        tagEditorPanel.getTitle().setText(id3.getTitle().toString());
        tagEditorPanel.getArtist().setText(id3.getArtist().toString());
        tagEditorPanel.getAlbum().setText(id3.getAlbum().toString());
        tagEditorPanel.getYear().setText(id3.getYear().toString());
        tagEditorPanel.getComment().setText(id3.getComment().toString());
        tagEditorPanel.getGenre().setText(String.format("%d", id3.getGenre().getByteFromVector(0)));
    }

}

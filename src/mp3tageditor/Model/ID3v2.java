package mp3tageditor.Model;

public class ID3v2 implements ID3 {

    public static final String ID3v2_TITLE_ID = "TIT2";
    public static final String ID3v2_ARTIST_ID = "TPE1";
    public static final String ID3v2_ALBUM_ID = "TALB";
    public static final String ID3v2_YEAR_ID = "TYER";
    public static final String ID3v2_COMMENT_ID = "COMM";
    public static final String ID3v2_GENRE_ID = "TCON";

    private ByteHolder signature;
    private ByteHolder title, artist, album;
    private ByteHolder year;
    private ByteHolder comment;
    private ByteHolder genre;

    @Override
    public ByteHolder getSignature() {
        return signature;
    }

    @Override
    public void setSignature(ByteHolder signature) {
        this.signature = signature;
    }

    @Override
    public ByteHolder getTitle() {
        return title;
    }

    @Override
    public void setTitle(ByteHolder title) {
        this.title = title;
    }

    @Override
    public ByteHolder getArtist() {
        return artist;
    }

    @Override
    public void setArtist(ByteHolder artist) {
        this.artist = artist;
    }

    @Override
    public ByteHolder getAlbum() {
        return album;
    }

    @Override
    public void setAlbum(ByteHolder album) {
        this.album = album;
    }

    @Override
    public ByteHolder getYear() {
        return year;
    }

    @Override
    public void setYear(ByteHolder year) {
        this.year = year;
    }

    @Override
    public ByteHolder getComment() {
        return comment;
    }

    @Override
    public void setComment(ByteHolder comment) {
        this.comment = comment;
    }

    @Override
    public ByteHolder getGenre() {
        return genre;
    }

    @Override
    public void setGenre(ByteHolder genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "ID3:"
                + "\nsignature=" + signature
                + "\ntitle=" + title
                + "\nartist=" + artist
                + "\nalbum=" + album
                + "\nyear=" + year
                + "\ncomment=" + comment
                + "\ngenre=" + genre;
    }

}

package mp3tageditor.Model;

public class ID3v1 implements ID3 {

    public static final int ID3v1_SIZE = 128;
    public static final int ID3v1_SIGNATURE_SIZE = 3;
    public static final int ID3v1_TITLE_SIZE = 30;
    public static final int ID3v1_ARTIST_SIZE = 30;
    public static final int ID3v1_ALBUM_SIZE = 30;
    public static final int ID3v1_YEAR_SIZE = 4;
    public static final int ID3v1_COMMENT_SIZE = 30;
    public static final int ID3v1_GENRE_SIZE = 1;

    private ByteHolder signature;
    private ByteHolder title, artist, album;
    private ByteHolder year;
    private ByteHolder comment;
    private ByteHolder genre;

    public ID3v1() {
    }

    public ID3v1(ByteHolder signature, ByteHolder title, ByteHolder artist, ByteHolder album, ByteHolder year, ByteHolder comment, ByteHolder genre) {
        this.signature = signature;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.comment = comment;
        this.genre = genre;
    }

    public byte[] getAsArray() {
        byte[] vector = new byte[ID3v1_SIZE];
        System.arraycopy(signature.getVector(), 0, vector, 0, 3);
        System.arraycopy(title.getVector(), 0, vector, 3, 30);
        System.arraycopy(artist.getVector(), 0, vector, 33, 30);
        System.arraycopy(album.getVector(), 0, vector, 63, 30);
        System.arraycopy(year.getVector(), 0, vector, 93, 4);
        System.arraycopy(comment.getVector(), 0, vector, 97, 30);
        System.arraycopy(genre.getVector(), 0, vector, 127, 1);

        return vector;
    }

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

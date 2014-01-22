package mp3tageditor.Model;

public interface ID3 {

    public ByteHolder getSignature();

    public void setSignature(ByteHolder signature);

    public ByteHolder getTitle();

    public void setTitle(ByteHolder title);

    public ByteHolder getArtist();

    public void setArtist(ByteHolder artist);

    public ByteHolder getAlbum();

    public void setAlbum(ByteHolder album);

    public ByteHolder getYear();

    public void setYear(ByteHolder year);

    public ByteHolder getComment();

    public void setComment(ByteHolder comment);

    public ByteHolder getGenre();

    public void setGenre(ByteHolder genre);

}

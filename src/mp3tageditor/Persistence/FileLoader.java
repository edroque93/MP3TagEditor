package mp3tageditor.Persistence;

import java.io.RandomAccessFile;
import java.util.Arrays;
import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3;

public class FileLoader {

    public static ID3 load(String path) {
        byte[] bytes = getBytesFromFile(path);
        return getID3FromBytes(bytes);
    }

    private static byte[] getBytesFromFile(String path) {
        byte[] bytes = new byte[ID3.ID3_SIZE];

        try {
            RandomAccessFile handle = new RandomAccessFile(path, "r");
            handle.seek(handle.length() - bytes.length);
            handle.readFully(bytes);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        return bytes;
    }

    private static ID3 getID3FromBytes(byte[] bytes) {
        ID3 id3 = new ID3();
        
        id3.setSignature(new ByteHolder(Arrays.copyOfRange(bytes, 0, 3)));
        id3.setTitle(new ByteHolder(Arrays.copyOfRange(bytes, 3, 33)));
        id3.setArtist(new ByteHolder(Arrays.copyOfRange(bytes, 33, 63)));
        id3.setAlbum(new ByteHolder(Arrays.copyOfRange(bytes, 63, 93)));
        id3.setYear(new ByteHolder(Arrays.copyOfRange(bytes, 93, 97)));
        id3.setComment(new ByteHolder(Arrays.copyOfRange(bytes, 97, 127)));
        id3.setGenre(new ByteHolder(Arrays.copyOfRange(bytes, 127, 128)));
        
        return id3;
    }
}

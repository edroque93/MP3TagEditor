package mp3tageditor.Persistence;

import java.io.RandomAccessFile;
import java.util.Arrays;
import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3v1;

public class FileLoaderID3v1 implements FileLoader {

    @Override
    public ID3v1 load(String path) {
        byte[] bytes = getBytesFromFile(path);
        return getID3FromBytes(bytes);
    }

    private byte[] getBytesFromFile(String path) {
        byte[] bytes = new byte[ID3v1.ID3v1_SIZE];

        try {
            RandomAccessFile handle = new RandomAccessFile(path, "r");
            handle.seek(handle.length() - bytes.length);
            handle.readFully(bytes);
            handle.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        return bytes;
    }

    private ID3v1 getID3FromBytes(byte[] bytes) {
        ID3v1 idv1 = new ID3v1();
        
        idv1.setSignature(new ByteHolder(Arrays.copyOfRange(bytes, 0, 3)));
        idv1.setTitle(new ByteHolder(Arrays.copyOfRange(bytes, 3, 33)));
        idv1.setArtist(new ByteHolder(Arrays.copyOfRange(bytes, 33, 63)));
        idv1.setAlbum(new ByteHolder(Arrays.copyOfRange(bytes, 63, 93)));
        idv1.setYear(new ByteHolder(Arrays.copyOfRange(bytes, 93, 97)));
        idv1.setComment(new ByteHolder(Arrays.copyOfRange(bytes, 97, 127)));
        idv1.setGenre(new ByteHolder(Arrays.copyOfRange(bytes, 127, 128)));
        
        return idv1;
    }
}

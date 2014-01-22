package mp3tageditor.Persistence;

import java.io.RandomAccessFile;
import mp3tageditor.Model.ID3v1;

public class SaveFile {

    public static void save(String path, ID3v1 id3) {
        if (tagInFile(path))
            writeID3ToFile(path, id3);
    }

    private static boolean tagInFile(String path) {
        ID3v1 id3 = FileLoader.load(path);
        return id3.getSignature().toString().contains("TAG");
    }

    private static void writeID3ToFile(String path, ID3v1 id3) {
        try {
            RandomAccessFile handle = new RandomAccessFile(path, "rw");
            handle.seek(handle.length() - ID3v1.ID3_SIZE);
            handle.write(id3.getAsArray());
            handle.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

    }

}

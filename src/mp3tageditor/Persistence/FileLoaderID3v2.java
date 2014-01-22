package mp3tageditor.Persistence;

import java.io.IOException;
import java.io.RandomAccessFile;
import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3v2;

public class FileLoaderID3v2 implements FileLoader {

    @Override
    public ID3v2 load(String path) {
        byte[] bytes = getBytesFromFile(path);
        return getID3FromBytes(bytes);
    }

    private byte[] getBytesFromFile(String path) {
        byte[] bytes = null;

        try {
            RandomAccessFile handle = new RandomAccessFile(path, "r");
            bytes = new byte[getSizeOfID3v2(handle)];
            handle.read(bytes);
            handle.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        return bytes;
    }

    private int getSizeOfID3v2(RandomAccessFile handle) throws IOException {
        byte[] head = new byte[10];
        int size = 0;
        handle.read(head);

        if (head[0] == 'I' && head[1] == 'D' && head[2] == '3' && head[3] == 3) {
            size = head[9];
            size += head[8] << 7;
            size += head[7] << 14;
            size += head[6] << 21;
        }

        return size;
    }

    private ID3v2 getID3FromBytes(byte[] bytes) {
        ID3v2 id3v2 = new ID3v2();

        id3v2.setSignature(new ByteHolder("TAG", 3));
        id3v2.setTitle(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_TITLE_ID)));
        id3v2.setArtist(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_ARTIST_ID)));
        id3v2.setAlbum(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_ALBUM_ID)));
        id3v2.setYear(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_YEAR_ID)));
        id3v2.setComment(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_COMMENT_ID)));
        id3v2.setGenre(new ByteHolder(searchFrame(bytes, ID3v2.ID3v2_GENRE_ID)));

        return id3v2;
    }

    private byte[] searchFrame(byte[] bytes, String tag) {
        int pointer = 0;
        int minimum = 5;

        while (pointer - minimum < bytes.length) {
            if (bytes[pointer] == tag.charAt(0)
                    && bytes[pointer + 1] == tag.charAt(1)
                    && bytes[pointer + 2] == tag.charAt(2)
                    && bytes[pointer + 3] == tag.charAt(3))
                return getDataFromTag(bytes, pointer);;
            pointer++;
        }

        return new byte[0];
    }

    private byte[] getDataFromTag(byte[] bytes, int pointer) {
        int size = bytes[pointer + 7];
        size += bytes[pointer + 6] << 8;
        size += bytes[pointer + 5] << 16;
        size += bytes[pointer + 4] << 24;

        System.out.println("POINTER+7 == " + bytes[pointer + 7]);
        System.out.println("POINTER+6 == " + bytes[pointer + 6]);
        System.out.println("POINTER+5 == " + bytes[pointer + 5]);
        System.out.println("POINTER+4 == " + bytes[pointer + 4]);

        byte[] result = new byte[size];

        if (!isDataUnicode(bytes, pointer))
            for (int i = 0; i < result.length; i++) {
                result[i] = bytes[pointer + 10 + i];
                System.out.print(((char) bytes[pointer + 10 + i]) + " - ");
                System.out.println(bytes[pointer + 10 + i]);
            }
        else {
            
        }

        System.out.println("END_________________________");
        return result;
    }

    private boolean isDataUnicode(byte[] bytes, int pointer) {
        return (bytes[pointer + 11] & 0xFF) >= 0xFE
                && (bytes[pointer + 12] & 0xFF) >= 0xFE;
    }

}

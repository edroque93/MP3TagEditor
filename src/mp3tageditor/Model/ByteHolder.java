package mp3tageditor.Model;

import java.io.UnsupportedEncodingException;

public class ByteHolder {

    private byte[] vector;
    private int pointer;
    private boolean isUnicode;

    public ByteHolder(String fromText, int size, boolean isUnicode) {
        this(size);
        this.isUnicode = isUnicode;

        if (!isUnicode)
            for (int i = 0; i <= size && i < fromText.length(); i++)
                sequentialWrite((byte) fromText.charAt(i));
        else
            for (int i = 0; i <= size && i < fromText.length(); i++) {
                int unicode = fromText.charAt(i);

                sequentialWrite((byte) unicode);
                sequentialWrite((byte) (unicode >> 8));
            }

    }

    public ByteHolder(int size) {
        pointer = 0;
        vector = new byte[size];
        isUnicode = false;
    }

    public ByteHolder(byte singleByte) {
        this(1);
        sequentialWrite(singleByte);
    }

    public ByteHolder(byte[] vector) {
        this.vector = vector;
        this.isUnicode = false;
    }
    
    public ByteHolder(byte[] vector, boolean isUnicode) {
        this.vector = vector;
        this.isUnicode = isUnicode;
    }

    public boolean isUnicode() {
        return isUnicode;
    }

    public void setUnicode(boolean isUnicode) {
        this.isUnicode = isUnicode;
    }

    public int getSize() {
        return vector.length;
    }

    public byte[] getVector() {
        return vector;
    }

    public byte getByteFromVector(int position) {
        if (position < vector.length)
            return vector[position];

        return 0;
    }

    public void sequentialWrite(byte data) {
        if (pointer < vector.length)
            vector[pointer++] = data;
    }

    public void resetSequence() {
        pointer = 0;
    }

    public void writePosition(int position, byte data) {
        if (position < vector.length)
            vector[position] = data;
    }

    @Override
    public String toString() {
        try {
            if (isUnicode)
                return new String(vector, "UTF-16LE").trim();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace(System.err);
        }

        return new String(vector).trim();
    }

}

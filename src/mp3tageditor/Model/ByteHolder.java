package mp3tageditor.Model;

public class ByteHolder {

    private byte[] vector;
    private int pointer;

    public ByteHolder(int size) {
        pointer = 0;
        vector = new byte[size];
    }

    public ByteHolder(byte[] vector) {
        this.vector = vector;
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
        if (pointer + 1 < vector.length)
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
        return new String(vector).trim();
    }
    
}


public class AsciiCharSequence implements CharSequence {
    private byte[] bytes;

    public AsciiCharSequence (byte [] bytes) {
       this.bytes = bytes.clone();
    }

    public int length() { return bytes.length; }

    public char charAt(int index) {
        return (char)bytes[index];
    }

    public AsciiCharSequence subSequence(int start, int end) {
        byte [] tmp = new byte[end - start];
        for (int i = 0; i < end - start; i++) {
            tmp[i] = bytes[i+start];
        }

        return new AsciiCharSequence(tmp);
    }

    public String toString () {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < bytes.length; i++) {
            s.append((char)bytes[i]);
        }
        return s.toString();
    }

}
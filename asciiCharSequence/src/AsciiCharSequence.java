import java.util.Arrays;

public class AsciiCharSequence implements java.lang.CharSequence {

    private final byte[] charSequence;

    AsciiCharSequence(byte[] byteSequence) {
        charSequence = byteSequence;
    }

    @Override
    public int length() {
        return charSequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char) charSequence[i];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(charSequence, start, end));
    }
    @Override
    public String toString(){
        return  new String(charSequence);
    }
}

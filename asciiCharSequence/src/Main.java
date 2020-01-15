public class Main {
    public static void main(String[] args) {
        byte[] b = {123, 123, 0, 67, -23};
        AsciiCharSequence a = new AsciiCharSequence(b);
        System.out.println(a.charAt(1));
        System.out.println(a.toString());
        System.out.println(a.length());
        System.out.println(a.subSequence(0, 1));
        System.out.println(a.subSequence(0, 5));

    }
}

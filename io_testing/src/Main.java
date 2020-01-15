import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int read, pre_read;
        pre_read = System.in.read();
        while (pre_read >= 0) {
            read = System.in.read();
            if (pre_read != 13 || read != 10)
                System.out.write(pre_read);
            pre_read = read;
        }
        System.out.flush();
    }
}

import java.io.*;
import java.util.Scanner;

public class Main {

//    Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
//    Пример
//    InputStream последовательно возвращает четыре байта: 48 49 50 51.
//    Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".

    public static void main(String[] args) {
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        String s = "a1 b2 c3";
        byte[] b = s.getBytes();
        ByteArrayInputStream inputStreamReader = new ByteArrayInputStream(b);

        Scanner scanner = new Scanner(inputStreamReader);
        double sum = 0.0;
        double temp;
        while (scanner.hasNext()) {
            try {
//                temp = Double.parseDouble(scanner.next());
                temp = Double.parseDouble(scanner.next());
                sum += temp;
            }
            catch (Exception e) {

            }
        }

        System.out.printf("%.6f", sum);
    }
}

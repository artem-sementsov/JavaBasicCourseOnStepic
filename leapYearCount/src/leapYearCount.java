import java.util.Scanner;

public class leapYearCount {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int input;
//        while (true) {
        int[] a1 = {0, 2, 2}, a2 = {1, 3};
        int c[] = a1;
        int b[] = mergeArrays(a1, a2);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
//        }
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int i1 = 0, i2 = 0;
        int t1, t2;
        int[] b = new int[a1.length + a2.length];
        while (i1 + i2 < a1.length + a2.length){
            t1 = (i1 < a1.length) ? a1[i1] : a2[a2.length - 1] + 1;
            t2 = (i2 < a2.length) ? a2[i2] : a1[a1.length - 1] + 1;
            if (t1 <= t2){
                b[i1 + i2] = t1;
                i1++;
            } else {
                b[i1 + i2] = t2;
                i2++;
            }
        }
            return b;
    }
}
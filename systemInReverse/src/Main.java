import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            if (++i % 2 == 0) {
                list.add(val);
            }
        }
        Collections.reverse(list);
        list.forEach(x -> System.out.print(x + " "));
    }
}

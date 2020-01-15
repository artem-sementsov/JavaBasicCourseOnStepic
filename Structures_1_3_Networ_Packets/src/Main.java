import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int n = scanner.nextInt();

        int current_time = 0;

        Map<Integer, Integer> stack = new TreeMap<>();
        Map<Integer, Integer> answer = new TreeMap<>();

        for (int i = 0; i < n; i++){
            int arrival = scanner.nextInt();
            int duration = scanner.nextInt();
            if (stack.size() == size) {
                answer.put(i,-1);
            } else {
                if (duration == 0) {
                    if (stack.isEmpty()) {
                        answer.put(i, arrival);
                    } else {
                        stack.put(arrival, duration);
                    }
                }
                if (current_time < arrival) {
                    current_time = arrival;
                    while (stack.)
                } else {

                }
            }

        }

        System.out.println();
    }
}

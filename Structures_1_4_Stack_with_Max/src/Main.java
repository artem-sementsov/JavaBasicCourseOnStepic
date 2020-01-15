import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max_stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            switch (s) {
                case "push":
                    int el = scanner.nextInt();
                    stack.push(el);
                    int max;
                    if (max_stack.isEmpty()) {
                        max = el;
                    } else {
                        max = (el > max_stack.peek()) ? el : max_stack.peek();
                    }
                    max_stack.push(max);
                    break;
                case "pop":
                    stack.pop();
                    max_stack.pop();
                    break;
                case "max":
                    System.out.println(max_stack.peek());
                    break;
            }
        }
    }
}

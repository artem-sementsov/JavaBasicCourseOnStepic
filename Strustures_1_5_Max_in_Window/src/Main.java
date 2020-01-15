import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
//stack for put
        Stack<Integer> push_stack = new Stack<>();
        Stack<Integer> push_max = new Stack<>();
//stack for get
        Stack<Integer> pop_stack = new Stack<>();
        Stack<Integer> pop_max = new Stack<>();
//together it's queue with maximum

        for (int i = 0; i < m; i++) {
            push_stack.push(ints[i]);
            int max;
            if (push_max.empty()) {
                max = ints[i];
            } else {
                max = (ints[i] > push_max.peek()) ? ints[i] : push_max.peek();
            }
            push_max.push(max);
        }

        System.out.print(push_max.peek());

        for (int i = m; i < n; i++) {
            if (pop_stack.empty()) {
                while (!push_stack.empty()) {
                    int el = push_stack.pop();
                    pop_stack.push(el);
                    push_max.pop();
                    int max;
                    if (pop_max.empty()) {
                        max = el;
                    } else {
                        max = (el > pop_max.peek()) ? el : pop_max.peek();
                    }
                    pop_max.push(max);
                }
            }
            pop_stack.pop();
            pop_max.pop();
            push_stack.push(ints[i]);
            int max;
            if (push_max.empty()) {
                max = ints[i];
            } else {
                max = (ints[i] > push_max.peek()) ? ints[i] : push_max.peek();
            }
            push_max.push(max);

            if (!pop_max.empty() && pop_max.peek() > max) {
                max = pop_max.peek();
            }
            System.out.print(" " + max);
        }

    }
}

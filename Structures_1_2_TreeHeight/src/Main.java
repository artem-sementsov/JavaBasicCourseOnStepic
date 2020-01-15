import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static Map<Integer, LinkedList<Integer>> tree = new TreeMap<>();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        Integer n = Integer.parseInt(scanner.nextLine());

        Integer n = 1000;


        for (int i = 0; i < n; i++) {
            //int cur = scanner.nextInt();
            int cur = -1 + i;
            LinkedList<Integer> children = tree.get(cur);
            if (children == null) {
                children = new LinkedList<>();
                children.add(i);
                tree.put(cur, children);
            } else {
                children.add(i);
            }
        }

//        tree.entrySet().stream().forEach(System.out::println);

        System.out.println(H(-1) - 1);

//        for (int i = 0; i < 10; i++) {
//            System.out.println(tree.get(i));
//        }
    }

    public static int H(Integer top) {
        int h = 1;
        LinkedList<Integer> children = tree.get(top);
        if (children != null) {
            for (Integer i : children) {
                int cur_h = H(i) + 1;
                if (cur_h > h) {
                    h = cur_h;
                }
            }
        }
//        System.out.println(top + " " + h);
        return h;
    }
}

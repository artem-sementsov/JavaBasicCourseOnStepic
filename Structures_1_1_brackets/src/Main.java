import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//
//        while (scanner.hasNextLine()) {
//            str = str + scanner.nextLine();
//        }

//        str = str.replaceAll("[^\\[\\]\\(\\)\\{\\}]", "");
//        System.out.println(str);

        String result  = String.valueOf(check(str));
        if (result.equals("-1")) result = "Success";
        System.out.println(result);

//        String[][] tests = {{"([](){([])})", "()[]}", "{{[()]]", "{{{[][][]", "{*{{}", "[[*", "{*}", "{{", "{}", "}","*{}", "{{{**[][][]"}
//                , {"0", "5", "7", "3", "3", "2", "0", "2", "0", "1", "0", "1"}};
//
//        for (int i = 0; i < tests.length; i++) {
//            assert check(tests[0][i]) == Integer.parseInt(tests[1][i]) :
//                    "Error " + (i + 1) + ": " + tests[0][i] + " : " + check(tests[0][i]) + " != " + tests[1][i];
//        }
    }

    public static int check(String str) {
        LinkedList<Character> stack = new LinkedList();
        String brackers = "()[]{}";
        int error_index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!brackers.contains(String.valueOf(ch))) continue;
            if (ch == '(' || ch == '[' || ch == '{') {
                if (stack.isEmpty()) {error_index = i;}
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return i + 1;
                char ch2 = stack.pop();
                if (ch == ')' && ch2 != '(') return i + 1;
                if (ch == ']' && ch2 != '[') return i + 1;
                if (ch == '}' && ch2 != '{') return i + 1;
            }
        }
        if (!stack.isEmpty()) return error_index + 1;
        return -1;
    }
}

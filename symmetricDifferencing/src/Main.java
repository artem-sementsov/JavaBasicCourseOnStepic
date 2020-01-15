import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new LinkedHashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new LinkedHashSet<Integer>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        Set<Integer> set = symmetricDifference(set1, set2);

        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set3 = new LinkedHashSet<>();
        Set<T> set4 = new LinkedHashSet<>();

        set3.addAll(set1);
        set3.removeAll(set2);

        set4.addAll(set2);
        set4.removeAll(set1);

        set3.addAll(set4);

        return set3;
    }
}

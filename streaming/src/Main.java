
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(new Integer(1), x -> x + 1)
                .limit(10);
        Comparator<Integer> comparator = Integer::compareTo;

//        System.out.println(comparator.compare(5,7));
        BiConsumer<Integer, Integer> consumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        findMinMax(stream, comparator, consumer);
//        findMinMax(Stream.empty(), comparator, consumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        ArrayList<T> list = new ArrayList<>();
        stream.sorted(order)
                .forEach(x -> list.add(x));
        int n = list.size();
            T min = (n > 0) ? list.get(0) : null;
            T max = (n > 0) ? list.get(n - 1) : null;
            minMaxConsumer.accept((min), max);
    }
}

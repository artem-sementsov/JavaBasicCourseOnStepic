import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
//        Pair<Integer, String> pair = Pair.of(1, "hello");
//        Integer i = pair.getFirst(); // 1
//        String s = pair.getSecond(); // "hello"
//
//        Pair<Integer, String> pair2 = Pair.of(1, "hello");
//        boolean mustBeTrue = pair.equals(pair2); // true!
//        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
//
//        String s1 = null;
//        Pair<Integer, String> pair3 = Pair.of(null, s1);
//        Integer i3 = pair3.getFirst();
//        String s3 = pair3.getSecond();
//
//        Pair<Integer, String> pair4 = Pair.of(null, s1);
//
//        Pair<Integer, String> pair5 = (Pair<Integer, String>) null;
//
//        System.out.println(pair3.equals(pair4));
//
//        System.out.println(i3 + " " + s3);
//
//        System.out.println(pair3.equals(null));
//        System.out.println(pair3.hashCode());
//
//        System.out.println(" " + i + " " + s + " " + mustBeTrue + " " + mustAlsoBeTrue);

        Collection<?> collection = new ArrayList<Object>();
        Object object = new Object();

        Object[] o = new Object[5];

        collection.clear();
        collection.remove(object);
        collection.iterator();
        collection.toArray();
//        collection.add(object);
        collection.contains(object);
        collection.size();
//        collection.addAll(Arrays.asList(o));

    }
}

class Pair <X,Y> {

    private X value0;
    private Y value1;

    private Pair(X value0, Y value1) {
        this.value0 = value0;
        this.value1 = value1;
    }

    X getFirst() {
        return value0;
    }
    Y getSecond() {
        return value1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (value0 != null ? !value0.equals(pair.value0) : pair.value0 != null) return false;
        return value1 != null ? value1.equals(pair.value1) : pair.value1 == null;
    }

    @Override
    public int hashCode() {
        int result = value0 != null ? value0.hashCode() : 0;
        result = 31 * result + (value1 != null ? value1.hashCode() : 0);
        return result;
    }

    public static <X,Y> Pair <X,Y> of(X value0, Y value1) {
        return new Pair<>(value0, value1);
    }
    public void ifPresent(BiConsumer <? super X, ? super Y> consumer) {

    }
}
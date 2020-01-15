import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;

        Function<Object, Integer> ifTrue = obj -> 0;

        Function<CharSequence, Integer> ifFalse = s -> s.length();

        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
//                x -> (condition.test(x)) ? ifTrue.apply(x) : ifFalse.apply(x);

        String s = null;
        String s1 = "124";
        String s2 = "";

        System.out.println(safeStringLength.apply(s));
        System.out.println(safeStringLength.apply(s1));
        System.out.println(safeStringLength.apply(s2));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> (condition.test(x)) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}

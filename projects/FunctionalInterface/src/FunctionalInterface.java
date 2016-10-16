import java.util.Objects;
import java.util.function.*;

public class FunctionalInterface {
    public static void main(String [] args) {

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply(null));

        Function <String, Integer> awesomeLength = (String arg) -> arg.length() * 3;

        System.out.println(awesomeLength.apply("awesomeString"));

    }


    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (T arg) -> condition.test(arg)
                ? ifTrue.apply(arg)
                : ifFalse.apply(arg);
    }
}

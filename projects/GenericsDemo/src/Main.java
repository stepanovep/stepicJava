import java.util.Optional;

/**
 * Created by captain_nemo on 10.10.16.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, "aloha");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(null, "aloha");

        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println(mustBeTrue);
    }


    public static class Pair <K, V> {
        private K first;
        private V second;

        private Pair (K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst()  {return first;}

        public V getSecond() {return second;}

        public static <K, V> Pair<K, V> of (K first, V second) {
            return new Pair<>(first, second);
        }


        public boolean equals(Pair<K, V> obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            return myequals(first, obj.first) && myequals(second, obj.second);
        }

        public boolean equalsFirst (K anotherFirst) {
            if (first == null && anotherFirst == null)
                return true;
            if (first != null && anotherFirst != null) {
                return first.equals(anotherFirst);
            }
            return false;
        }

        public boolean equalsSecond (V anotherSecond) {
            if (second == null && anotherSecond == null)
                return true;
            if (second != null && anotherSecond != null) {
                return second.equals(anotherSecond);
            }
            return false;
        }

        public <T, U> boolean myequals (T a, U b) {
            if (a == null && b == null)
                return true;

            if (a != null && b != null) {
                if (a.getClass() == b.getClass()) {
                    return a.equals(b);

                } else
                    return false;

            } else
                return false;
        }

        public int hashCode() {
            if (first == null || second == null) {
                return 0;
            }
            return first.getClass().toString().length() +
                    getClass().toString().length();
        }
    }
}

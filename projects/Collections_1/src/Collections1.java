import java.io.IOException;
import java.util.*;

public class Collections1 {
    public static void main(String[] args) throws IOException{
        int c;
        int i = 0;
        List<Integer> list = new LinkedList<>();

        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNext()) {
                c = Integer.parseInt(scan.next());
                if (i % 2 == 1) {
                    list.add(c);
                }
                i++;
            }
        }

        Collections.reverse(list);
        for (Integer value : list)
            System.out.print(value + " ");
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> diffSet = new HashSet<T>();
        for (T value: set1) {
            if (!set2.contains(value))
                diffSet.add(value);
        }

        for (T value: set2) {
            if (!set1.contains(value))
                diffSet.add(value);
        }

        return diffSet;
    }
}

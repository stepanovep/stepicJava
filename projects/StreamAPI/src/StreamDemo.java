import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class StreamDemo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("utf8")));
        String text = reader.readLine();

        String [] words = text.split("[^\\p{LD}]+");
        List <String> listWords = new LinkedList<>();

        for (String word : words)
            listWords.add(word.toLowerCase());

        Map <String, Integer> wordCount = new HashMap<>();
        for (String word : listWords) {
            int currentCount = wordCount.containsKey(word) ? wordCount.get(word) : 0;
            wordCount.put(word, currentCount+1);
        }

        Set <String> ans = wordCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n*n / 10) % 1000);
    }


    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        ArrayList <T> array = new ArrayList<T>();
        stream.forEach(array::add);
        array.sort(order);
        if (array.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }
        else {
            T min = array.get(0);
            T max = array.get(array.size()-1);
            minMaxConsumer.accept(min, max);
        }
    }

}

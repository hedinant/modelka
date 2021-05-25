import javafx.util.Pair;

import java.util.*;
import java.util.function.ToIntFunction;

public class Interview {

    /*
    Есть массив целых чисел и число K.
    Найти два таких (не обязательно различных) числа в массиве, сумма которых равна K, либо вывести, что такого нет
     * */
    public static Pair<Integer, Integer> findAdditionPairFor(int[] data, int sum) {
        if (data.length == 0)
            return null;
        Set<Integer> set = new HashSet<>(data.length);
        for (int i : data)
            set.add(i);

        while (!set.isEmpty()) {
            Integer integer = set.iterator().next();
            if (integer * 2 == sum)
                return new Pair<>(integer, integer);
            Integer pair = sum - integer;
            if (set.contains(pair))
                return new Pair<>(integer, pair);
            set.remove(integer);
        }
        return null;
    }

    public static void main(String[] args) {
        sortedFlatMapPrint(Arrays.asList(new int[]{1, 3, 5}, new int[]{2, 4, 6}, new int[]{3, 4, 5}));
    }

    /*
    Дано K сортированных числовых массивов длины N.
    Вывести в консоль отсортированную последовательность всех чисел.
    * */

    // List implementation based on ArrayList expected
    public static void sortedFlatMapPrint(List<int[]> data) {
        TreeSet<Pair<Integer, Integer>> tree = new TreeSet<>(
                Comparator.comparingInt((ToIntFunction<Pair<Integer, Integer>>) Pair::getKey)
                        .thenComparingInt(Pair::getValue));
        int[] indexes = new int[data.size()];
        for (int i = 0; i < data.size(); i++)
            tree.add(new Pair<>(data.get(i)[0], i));

        while (!tree.isEmpty()) {
            Pair<Integer, Integer> next = tree.pollFirst();
            System.out.println(next.getKey());
            Integer arrayNumber = next.getValue();
            int nextIndex = indexes[arrayNumber] + 1;
            int[] arr = data.get(arrayNumber);
            if (nextIndex < arr.length) {
                indexes[arrayNumber] = nextIndex;
                tree.add(new Pair<>(arr[nextIndex], arrayNumber));
            }
        }
    }
}
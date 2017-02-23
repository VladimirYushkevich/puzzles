package trial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SimpleQueries {

    static int[] counts(int[] nums, int[] maxes) {
        final Set<Integer> maxesInOrder = new TreeSet<>(IntStream.of(maxes).boxed().collect(toList()));
        final List<Integer> numsList = IntStream.of(nums).boxed().collect(toList());
        final NavigableMap<Integer, Integer> res = new TreeMap<>();

        maxesInOrder.stream().forEach(m -> findLess(m, res, numsList));

        return IntStream.of(maxes).boxed().mapToInt(res::get).toArray();
    }

    private static void findLess(Integer m, NavigableMap<Integer, Integer> res, List<Integer> numsList) {
        int count = 0;
        final Iterator<Integer> iterator = numsList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= m) {
                iterator.remove();
                count++;
            }
        }
        if (!res.isEmpty()) {
            count += res.lastEntry().getValue();
        }
        res.put(m, count);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("/simple_queries/test_case_0.txt");
        final String fileName = SimpleQueries.class.getResource("/simple_queries/test_case_0.txt").getFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;

        int _nums_size = 0;
        _nums_size = Integer.parseInt(in.nextLine().trim());
        int[] _nums = new int[_nums_size];
        int _nums_item;
        for (int _nums_i = 0; _nums_i < _nums_size; _nums_i++) {
            _nums_item = Integer.parseInt(in.nextLine().trim());
            _nums[_nums_i] = _nums_item;
        }


        int _maxes_size = 0;
        _maxes_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxes = new int[_maxes_size];
        int _maxes_item;
        for (int _maxes_i = 0; _maxes_i < _maxes_size; _maxes_i++) {
            _maxes_item = Integer.parseInt(in.nextLine().trim());
            _maxes[_maxes_i] = _maxes_item;
        }

        res = counts(_nums, _maxes);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}

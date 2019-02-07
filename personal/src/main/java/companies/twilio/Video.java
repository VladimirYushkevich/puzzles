package companies.twilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Video {
    //[1,2,3] => [], [1], [2], [3], [1, 2], [2, 3], [1, 2, 3]
    /*
    slice = 0;
    []
    slice = 1;
    0
    1
    2
    slice = 2;
    0, 1
    1, 2
    slice = 3;
    1, 2, 3
     */

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        int size = input.size();

        for (int slice = 1; slice <= size; slice++) {
            for (int start = 0; start <= size - slice; start++) {
                List<Integer> output = new ArrayList<>(slice);
                for (int i = start; i < start + slice; i++) {
                    output.add(input.get(i));
                }
                output.forEach(nb -> System.out.print(nb + " "));
                System.out.println();
            }
        }
    }
}

package companies.twilio;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    static String findNumber(List<Integer> arr, int k) {
        for (int elem : arr) {
            if (elem == k) {
                return "YES";
            }
        }

        return "NO";
    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 > 0) {
                res.add(i);
            }
        }

        return res;
    }
}

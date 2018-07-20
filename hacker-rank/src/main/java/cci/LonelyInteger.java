package cci;

import java.util.List;

public class LonelyInteger {

    static int findLonely(List<Integer> arr) {
        int lonely = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            lonely = lonely ^ arr.get(i);
        }

        return lonely;
    }
}

package cci.book;

import java.util.ArrayList;
import java.util.List;

/*
Problem from CCI (RU) findPermutations.67
 */
public class StringPermutation {

    public List<String> findAllPermutations(String input) {
        return findPermutations(input, new ArrayList<>());
    }

    /*
    findPermutations(a) = [a]
    findPermutations(ab) = [ab,ba]

    findPermutations(abc) = insert c findPermutations(ap)
     */
    private List<String> findPermutations(String s, List<String> res) {
        String last = s.substring(s.length() - 1);
        String first = s.substring(0, s.length() - 1);

        if (first.isEmpty()) {
            res.add(last);
            return res;
        }

        return insertInAllPositions(findPermutations(first, res), last);
    }

    private List<String> insertInAllPositions(List<String> permutations, String last) {
        List<String> res = new ArrayList<>();
        for (String permutation : permutations) {
            for (int i = 0; i <= permutation.length(); i++) {
                String inserted = permutation.substring(0, i) + last + permutation.substring(i);
                res.add(inserted);
            }
        }

        return res;
    }
}

package companies.yilu;

import java.util.*;
import java.util.stream.Collectors;

public class Questions {

    public Optional<Character> findFirstNonRepeatedCharacter(String input) {
        Set<Character> existed = new HashSet<>();
        Set<Character> notExisted = new LinkedHashSet<>();

        for (char ch : input.toCharArray()) {
            if (existed.contains(ch)) {
                notExisted.remove(ch);
            } else {
                notExisted.add(ch);
                existed.add(ch);
            }
        }

        Iterator<Character> iterator = notExisted.iterator();
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        }

        return Optional.empty();
    }

    public boolean isRotation(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int length = charsA.length;

        if (length != charsB.length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (charsA[i] != charsB[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public int sum(List<Integer> input) {
        return input.stream()
                .reduce(0, (a, b) -> a + b);
    }

    public int product(List<Integer> input) {
        return input.stream()
                .reduce(1, (a, b) -> a * b);
    }

    public List<Integer> addNumber(List<Integer> input, int number) {
        return input.stream()
                .map(i -> i + number)
                .collect(Collectors.toList());
    }

    public List<Integer> flattenAndAddNumber(Map<String, List<Integer>> input, int number) {
        return input.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .map(i -> i + number)
                .collect(Collectors.toList());
    }
}

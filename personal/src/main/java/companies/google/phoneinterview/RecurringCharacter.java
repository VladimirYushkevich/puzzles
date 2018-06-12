package companies.google.phoneinterview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class RecurringCharacter {

    static Character getFirstRecurringCharacter(String input) {
        Set<Character> existed = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (existed.contains(ch)) {
                return ch;
            } else {
                existed.add(ch);
            }
        }
        return null;
    }

    static Character getFirstNonRecurringCharacter(String input) {
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
            return iterator.next();
        }

        return null;
    }
}

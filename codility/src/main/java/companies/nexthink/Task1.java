package companies.nexthink;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    @SafeVarargs
    final Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null) {
            return new HashMap<>();
        }

        return Arrays.stream(visits)
                .filter(Objects::nonNull)
                .flatMap(m -> m.entrySet().stream())
                .filter(e -> isNumeric(e.getKey()))
                .filter(e -> e.getValue() != null && e.getValue().getVisitCount() != null)
                .collect(Collectors.toMap(e -> Long.parseLong(e.getKey()),
                        e -> e.getValue().getVisitCount(), Long::sum, HashMap::new));
    }

    private static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static class UserStats {
        private final Long visitCount;

        public UserStats(Long visitCount) {
            this.visitCount = visitCount;
        }

        public Long getVisitCount() {
            return visitCount;
        }
    }
}

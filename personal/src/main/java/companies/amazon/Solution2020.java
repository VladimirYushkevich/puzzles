package companies.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution2020 {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> numbers = new ArrayList<>();
        List<LogLine> wordsOrAlphanumeric = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < logFileSize; i++) {
            String logLine = logLines.get(i);
            String[] split = logLine.split(" ", 2);
            String identifier = split[0];
            System.out.println("->" + identifier);
            String tail = split[1];
            if (hasWordOnly(tail)) {
                wordsOrAlphanumeric.add(new LogLine(identifier, tail));
            } else if (hasNumbersOnly(tail)) {
                numbers.add(logLine);
            } else {
                wordsOrAlphanumeric.add(new LogLine(identifier, tail));
            }
        }

        wordsOrAlphanumeric.sort((o1, o2) -> {
            System.out.println(o2.identifier);
            if (o1.tail.equals(o2.tail)) {
                return o1.identifier.compareTo(o2.identifier);
            } else {
                return o1.tail.compareTo(o2.tail);
            }
        });

        for (LogLine logLine : wordsOrAlphanumeric) {
            res.add("[" + logLine.identifier + " " + logLine.tail + "]");
        }
        res.addAll(numbers);

        return res;
    }

    private boolean hasWordOnly(CharSequence seq) {
        int len = seq.length();
        for (int i = 0; i < len; i++) {
            char c = seq.charAt(i);
            if ('a' <= c && c <= 'z') continue;
            if (c == ' ') continue;
            return false;
        }
        return true;
    }

    private boolean hasNumbersOnly(CharSequence seq) {
        int len = seq.length();
        for (int i = 0; i < len; i++) {
            char c = seq.charAt(i);
            if ('0' <= c && c <= '9') continue;
            if (c == ' ') continue;
            return false;
        }
        return true;
    }

    static class LogLine {
        String identifier;
        String tail;

        public LogLine(String identifier, String tail) {
            this.identifier = identifier;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return "LogLine{" +
                    "identifier='" + identifier + '\'' +
                    ", tail='" + tail + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogLine logLine = (LogLine) o;
            return identifier.equals(logLine.identifier) &&
                    tail.equals(logLine.tail);
        }

        @Override
        public int hashCode() {
            return Objects.hash(identifier, tail);
        }
    }
}

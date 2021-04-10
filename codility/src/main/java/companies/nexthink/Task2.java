package companies.nexthink;

public class Task2 {

    public int solution(int N) {
        final char[] chars = String.valueOf(N).toCharArray();
        final boolean isNegative = chars[0] == '-';

        StringBuilder result = new StringBuilder();
        boolean isChanged = false;
        for (char c : chars) {
            int x = c - '0';

            if (!isNegative && !isChanged && x < 5) {
                result.append('5');
                isChanged = true;
            }
            if (isNegative && !isChanged && x > 5) {
                result.append('5');
                isChanged = true;
            }

            result.append(c);
        }

        if (!isChanged) {
            result.append('5');
        }

        return Integer.parseInt(result.toString());
    }
}

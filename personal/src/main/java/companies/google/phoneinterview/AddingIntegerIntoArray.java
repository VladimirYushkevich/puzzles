package companies.google.phoneinterview;

class AddingIntegerIntoArray {

    static int[] addInt(int[] input) {
        int size = input.length;
        int currentResult = 0;
        for (int i = size - 1; i >= 0; i--) {
            int current = input[i];
            currentResult = current + 1;
            if (currentResult == 10) {
                input[i] = 0;
                continue;
            }

            input[i] = currentResult;
            break;
        }

        if (currentResult == 10) {
            int[] result = new int[size + 1];
            result[0] = 1;
            return result;
        }

        return input;
    }
}

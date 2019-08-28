package companies.finleap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<String, Integer> duplicates = new HashMap<>();

    static String solution(String S, String C) {
        final StringBuilder res = new StringBuilder();

        final String separator = "; ";
        final String[] employees = S.split(separator);
        for (String employee : employees) {
            final String[] name = employee.split(" ");
            final String firstName = name[0];
            final String lastName = name[name.length - 1];
            final String formattedFirstName = String.valueOf(firstName.charAt(0)).toLowerCase();
            final String formattedLastName = lastName.replaceAll("-", "").toLowerCase();
            final String emailName = String.format("%s_%s", formattedFirstName, formattedLastName);

            Integer numberOfDuplicates = duplicates.getOrDefault(emailName, 1);
            String uniqueEmailName = emailName;
            if (numberOfDuplicates > 1) {
                uniqueEmailName = emailName + numberOfDuplicates;
            }
            final String email = String.format("%s@%s.com", uniqueEmailName, C.toLowerCase());
            res.append(email);
            res.append(separator);
            duplicates.put(emailName, ++numberOfDuplicates);
        }

        String output = res.toString();
        int start = output.lastIndexOf(separator);
        return output.substring(0, start);
    }
}

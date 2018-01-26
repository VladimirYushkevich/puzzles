package algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {

    static String solution(String s) {
        String[] split = s.split(":");

        String sec = split[2].substring(0, 2);
        String midnight = split[2].substring(2, 4);

        short hours = Short.valueOf(split[0]);
        String hoursValue = "PM".equals(midnight) ? "12" : "00";
        if ("PM".equals(midnight) && hours < 12) {
            hours += 12;
            hoursValue = String.valueOf(hours);
        } else if (hours < 10) {
            hoursValue = "0" + String.valueOf(hours);
        }

        return String.format("%s:%s:%s", hoursValue, split[1], sec);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = solution(s);
        System.out.println(result);
    }
}

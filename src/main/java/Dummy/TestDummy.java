package Dummy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDummy {
    /**
     * Converts 12h to 24h time
     * @param s The time to convert in format HH:MM:SS *M
     * @return Time in 24H format.
     */
    public static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String regexPattern = "(\\d\\d):(\\d\\d):(\\d\\d)([AP])M";
        Pattern pattern12h = Pattern.compile(regexPattern);

        Matcher matcher = pattern12h.matcher(s);
        String returnString = null;

        if(matcher.find()){
            int hour = Integer.parseInt(matcher.group(1));
            int minute = Integer.parseInt(matcher.group(2));
            int second = Integer.parseInt(matcher.group(3));
            String meridiem = matcher.group(4);

            if(meridiem.equals("A")){
                if(hour == 12){
                    hour -= 12;
                }
            }

            if(meridiem.equals("P")){
                if(hour != 12){
                    hour += 12;
                }
            }

            returnString = String.format("%02d:%02d:%02d", hour, minute, second);
        }

        return returnString;
    }
}

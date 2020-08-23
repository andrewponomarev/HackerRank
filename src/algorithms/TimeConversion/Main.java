package algorithms.TimeConversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 01.11.17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

    private static String timeConversion(String s) {
        String patternFrom = "hh:mm:ssa";
        String patternTo = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(patternFrom);
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch(ParseException e) {
            System.out.println("bad news");
        }
        sdf.applyPattern(patternTo);
        return sdf.format(date);
    }
}

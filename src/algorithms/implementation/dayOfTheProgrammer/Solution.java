package algorithms.implementation.dayOfTheProgrammer;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 07.11.17.
 */
public class Solution {

    static String solve(int year) {
        if (year != 1918) {
            if (isLeap(year)) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        } else {
            return "26.09." + year;
        }
    }



    private static boolean isLeap(int year) {
        if (year < 1918 && year % 4 == 0) {
            return true;
        }
        if (year > 1918 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int year = in.nextInt();
            String result = solve(year);
            System.out.println(result);
    }
}


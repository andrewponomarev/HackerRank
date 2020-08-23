package cracking_the_coding_interview.string_making_angrams;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 02.11.17.
 */
public class Solution {

    public static int numberNeeded(String first, String second) {
        int fl = first.length();
        int sl = second.length();
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();
        Arrays.sort(f);
        Arrays.sort(s);

        int count = 0;
        int i = 0;
        int j = 0;

        while (true) {
            if (i == fl) {
                count += sl - j;
                break;
            }
            if (j == sl) {
                count += fl - i;
                break;
            }
            if (f[i] == s[j]) {
                j++; i++;
            } else if (f[i] < s[j]) {
                count++; i++;
            } else {
                count++; j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

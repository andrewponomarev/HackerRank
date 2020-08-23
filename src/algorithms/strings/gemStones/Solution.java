package algorithms.strings.gemStones;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 07.11.17.
 */
public class Solution {

    static int gemstones(String[] arr){
        boolean[] ch = new boolean[26];
        String s = arr[0];
        for (char c : s.toCharArray()) {
            ch[c-97] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            boolean[] tempCh = new boolean[26];
            for (char c : arr[i].toCharArray()) {
                tempCh[c-97] = true;
            }
            for (int j = 0; j < 26; j++) {
                ch[j] = ch[j] && tempCh[j];
            }
        }
        int count = 0;
        for (boolean c : ch) {
            if (c) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }

}

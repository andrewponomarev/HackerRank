package algorithms.greedy.bunsFans;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] t = new int[n];
        int[] d = new int[n];
        SortedMap<Integer, Set<Integer>> completeTime = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            t[i] = scan.nextInt();
            d[i] = scan.nextInt();
            completeTime.putIfAbsent(t[i] + d[i], new TreeSet<>());
            completeTime.get(t[i] + d[i]).add(i + 1);
        }
        for (Set<Integer> times : completeTime.values()) {
            for (Integer i : times) {
                System.out.printf("%d ", i);
            }
        }
    }
}

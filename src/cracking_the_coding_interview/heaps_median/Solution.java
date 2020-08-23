package cracking_the_coding_interview.heaps_median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 08.11.17.
 */
public class Solution {

    PriorityQueue<Integer> lowers;
    PriorityQueue<Integer> highers;

    Solution() {
        highers = new PriorityQueue<Integer>();
        lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
    }

    private void addToList(int value) {
        addNumber(value);
        rebalanceHeaps();
    }

    private void rebalanceHeaps() {
        PriorityQueue<Integer> bigHeap = highers.size() > lowers.size() ? highers : lowers;
        PriorityQueue<Integer> litteHeap = highers.size() > lowers.size() ? lowers : highers;

        if (bigHeap.size() - litteHeap.size() == 2) {
            litteHeap.add(bigHeap.poll());
        }

    }

    private void addNumber(int value) {
        if (highers.size() == 0 && lowers.size() == 0) {
            highers.add(value);
            return;
        }
        if (lowers.size() == 0) {
            if (value < highers.peek()) {
                lowers.add(value);
            } else {
                highers.add(value);
            }
            return;
        }
        if (value < lowers.peek()) {
            lowers.add(value);
        } else {
            highers.add(value);
        }
    }

    private double findMedian() {
        if (highers.size() == lowers.size()) {
            return (highers.peek() + lowers.peek()) / 2.0;
        } else if (highers.size() > lowers.size()) {
            return highers.peek();
        } else {
            return lowers.peek();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution solution = new Solution();

        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            solution.addToList(a[a_i]);
            System.out.println(solution.findMedian());
        }
    }
}

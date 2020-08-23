package dataStructure.queues.truckTour;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            petrol[i] = in.nextInt();
            distance[i] = in.nextInt();
        }
        System.out.println(smallestPetrolPump(petrol, distance, n));
    }

    private static int smallestPetrolPump(int[] petrol, int[] distance, int n) {
        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = petrol[i] - distance[i];
        }
        int firstIndex = 0;
        while (dif[firstIndex] < 0) {
            firstIndex++;
        }
        Set<String> a;
        int queueSize = 0;
        int sum = 0;
        int curIndex = firstIndex;
        while (queueSize != n  && firstIndex != n) {
            sum += dif[curIndex];
            curIndex = (curIndex + 1) % n;
            queueSize++;
            while (sum < 0 && firstIndex != n) {
                sum -= dif[firstIndex];
                firstIndex++;
                queueSize--;
            }
            if (queueSize < 0) {
                curIndex = firstIndex;
                queueSize = 0;
            }
        }
        return firstIndex;
    }

}

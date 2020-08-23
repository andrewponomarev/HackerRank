package cracking_the_coding_interview.hashTables_ransomNote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 02.11.17.
 */
public class Solution {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        fillMap(magazine, magazineMap);
        fillMap(note, noteMap);
    }

    private void fillMap(String str, Map<String, Integer> map) {
        for (String s : str.split(" ")) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
    }

    public boolean solve() {
        for (String key : noteMap.keySet()) {
            if (magazineMap.get(key) < noteMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }

}

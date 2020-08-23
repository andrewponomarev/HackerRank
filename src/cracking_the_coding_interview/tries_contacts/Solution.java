package cracking_the_coding_interview.tries_contacts;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by ponomarevandrew on 08.11.2017.
 */
public class Solution {

    static class Trie{

        static class Node {
            Map<Character, Node> children = new TreeMap<>();
            boolean leaf;
        }

        Node root = new Node();

        public void add(String s) {
            Node v = root;
            for (char ch : s.toCharArray()) {
                if (!v.children.containsKey(ch)) {
                    v.children.put(ch, new Node());
                }
                v = v.children.get(ch);
            }
            v.leaf = true;
        }

        public int find(String s) {
            Node v = root;
            for (char ch : s.toCharArray()) {
                if (!v.children.containsKey(ch)) {
                    return 0;
                } else {
                    v = v.children.get(ch);
                }
            }
            return numOfLeafs(v);

        }

        private int numOfLeafs(Node v) {
            int count = 0;
            for ( Node node : v.children.values()) {
                count =+ numOfLeafs(node);
            }
            if (v.leaf) {
                return count + 1;
            } else {
                return count;
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie contacts = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if (op.equals("add")) {
                contacts.add(contact);
            }
            if (op.equals("find")) {
                System.out.println(contacts.find(contact));
            }
        }
    }


}

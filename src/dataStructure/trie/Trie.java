package dataStructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ponomarevandrew on 08.11.2017.
 */
public class Trie {

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

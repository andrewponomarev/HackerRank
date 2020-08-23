package cracking_the_coding_interview.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ponomarevandrew on 08.11.17.
 */
public class Solution {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        List<Node> inOrder = new ArrayList<Node>();
        fillInOrder(root, inOrder);
        for (int i = 0; i < inOrder.size() - 1; i++) {
            if (inOrder.get(i).data >= inOrder.get(i+1).data)
                return false;
        }
        return true;
    }

    private void fillInOrder(Node root, List<Node> inOrder) {
        if (root == null) return;
        fillInOrder(root.left, inOrder);
        inOrder.add(root);
        fillInOrder(root.right, inOrder);
    }


}

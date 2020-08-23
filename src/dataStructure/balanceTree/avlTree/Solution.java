package dataStructure.balanceTree.avlTree;

public class Solution {

    static class Node {
        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child
    }

    static Node insert(Node root,int val)
    {
        if (root == null) {
            root = new Node();
            root.val = val;
            return root;
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }
        calcHt(root);
        root = balanceTree(root);
        return root;
    }

    private static void calcHt(Node root) {
        int leftHt = root.left == null ? -1 : root.left.ht;
        int rightHt = root.right == null ? -1 : root.right.ht;
        root.ht = Math.max(leftHt, rightHt) + 1;
    }

    private static Node balanceTree(Node root) {
        int rootBalanceFactor = balanceFactor(root);
        if (rootBalanceFactor > 1) {
            if (balanceFactor(root.left) == -1) {
                swapWithRight(root.left);
            }
            if (balanceFactor(root.left) == 1) {
                return swapWithLeft(root);
            }
        } else if (rootBalanceFactor < -1) {
            if (balanceFactor(root.right) == 1) {
                swapWithLeft(root.right);
            }
            if (balanceFactor(root.right) == -1) {
                return swapWithRight(root);
            }
        }
        return root;
    }

    private static int balanceFactor(Node root) {
        int leftHight = root.left == null ? -1 : root.left.ht;
        int rightHight = root.right == null ? -1 : root.right.ht;
        return leftHight - rightHight;
    }

    private static Node swapWithLeft(Node node){
       Node left = node.left;
       node.left = left.right;
       left.right = node;

       node.ht = left.ht - 1;
       calcHt(left);

       return left;
    }

    private static Node swapWithRight(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;

        node.ht = right.ht - 1;
        calcHt(right);
        return right;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.right.right = new Node(5);

        Node n = insert(root, 6);
        System.out.println(balanceFactor(root));
    }
}

package algorithms.search.hanoiTower;

import java.util.*;

public class Solution {

    Node target;

    Node root;

    public Solution(int[] a) {
        root = new Node(a, 0);
        int[] targetState = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            targetState[i] = 1;
        }
        target = new Node(targetState, 0);
    }

    private int hanoiSteps() {
        Set<Node> visited = new HashSet<>();
        return hanoiSteps(root, visited);
    }

    private int hanoiSteps(Node source, Set<Node> visited) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node.equals(target)) {
                return node.level;
            }
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            nextToVisit.addAll(node.children());
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = 1;
        }

        Solution solution = new Solution(a);
        System.out.println(solution.hanoiSteps());
    }

    class Node {
        int[] state;
        int level;

        Node(int[] state, int level) {
            this.state = state;
            this.level = level;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null) return false;
            if (this.getClass() != other.getClass()) return false;
            Node node = (Node) other;
            if (this.state == node.state) {
                return true;
            }
            if (this.state == null) return false;
            if (node.state == null) return false;
            if (this.state.length != node.state.length) return false;

            for (int i = 0; i < this.state.length; i++) {
                if (this.state[i] != node.state[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(state);
        }

        List<Node> children() {
            int[] topRods = topRods();
            int[] rods = new int[4];
            for (int i = 0; i < 4; i++){
                rods[i] = i;
            }

            List<Node> children = new ArrayList<>();
            sort(topRods, rods);
            int[] arr = this.state;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (topRods[i] == 1000000) continue;
                for (int j = 3; j > i; j--) {
                    int[] childState = arr.clone();
                    childState[topRods[i]] = rods[j] + 1;
                    children.add(new Node(childState, this.level + 1));
                 }
                count++;
            }
            return children;
        }

        private void sort(int[] toSort, int[] additional) {
            for (int i = 0; i < toSort.length - 1; i++) {
                for (int j = i + 1; j < toSort.length; j++) {
                    if (toSort[i] >= toSort[j]) {
                        int temp = toSort[i];
                        toSort[i] = toSort[j];
                        toSort[j] = temp;
                        temp = additional[i];
                        additional[i] = additional[j];
                        additional[j] = temp;
                    }
                }
            }
        }

        private int[] topRods() {
           int[] result = new int[4];
           for (int i =0; i < 4; i++){
               result[i] = 1000000;
           }
           int count = 0;
           int i = 0;
           int[] arr = this.state;
           while (i < arr.length && count < 4){
               if (result[arr[i] - 1] == 1000000) {
                   result[arr[i] - 1] = i;
                   count++;
               }
               i++;
           }
           return result;
        }

    }

}

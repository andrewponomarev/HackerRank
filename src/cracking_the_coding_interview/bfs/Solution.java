package cracking_the_coding_interview.bfs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {

        // количество вершин
        private final int V;
        // количество ребер
        private int E;
        // списки смежных вершин
        private List<Integer>[] adj;



        public Graph(int size) {
            V = size;
            E = 0;
            adj =(LinkedList<Integer>[])new LinkedList[size];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int first, int second) {
            adj[first].add(second);
            adj[second].add(first);
            E++;
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] result = new int[V];
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                result[i] = -1;
            }
            LinkedList<Integer> nextToVisit = new LinkedList<>();
            nextToVisit.add(startId);
            result[startId] = 0;
            visited[startId] = true;
            while (!nextToVisit.isEmpty()) {
                int node = nextToVisit.remove();
                int dist = result[node];
                List<Integer> children = adj[node];
                for (int c : children) {
                    if (!visited[c]) {
                        nextToVisit.add(c);
                        result[c] = dist + 6;
                        visited[c] = true;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}



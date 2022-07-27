package SamsungSDSalgo.DAY7.BOJ1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라
 */

public class Main {

    static int V, E;
    static ArrayList<Node>[] list;
    static PriorityQueue<Node> pq;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];
        arr = new int[V + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.add(new Node(K, 0));
        arr[K] = 0;

        dijkstra();

        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i] == Integer.MAX_VALUE ? "INF" : arr[i]);
        }
    }

    static class Node{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static void dijkstra() {
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int cur = node.to;
            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : list[cur]) {
                    if (arr[next.to] > arr[cur] + next.weight) {
                        arr[next.to] = arr[cur] + next.weight;
                        pq.add(new Node(next.to, arr[next.to]));
                    }
                }
            }
        }
    }
}

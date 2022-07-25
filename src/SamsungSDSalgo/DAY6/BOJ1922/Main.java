package SamsungSDSalgo.DAY6.BOJ1922;


import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 신장 트리 - Kruskal
 */

public class Main {

    static int V, E, count = 0, sum = 0;
    static int[] parents;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        parents = new int[V + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node node = new Node(from, to, weight);
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (find(node.getFrom()) != find(node.getTo())) {

                union(node.getFrom(), node.getTo());

                sum += node.getWeight();
                count++;
            }

            if (count == V - 1) {
                break;
            }
        }

        bw.write(String.valueOf(sum));
        bw.close();
        br.close();
    }

    static class Node {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }

    static void union(int from, int to) {
        from = find(from);
        to = find(to);

        if (from != to) {
            parents[from] = to;
        }

    }

    static int find(int a) {
        return (parents[a] == a) ? a : find(parents[a]);
    }
}

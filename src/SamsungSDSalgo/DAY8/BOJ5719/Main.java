package SamsungSDSalgo.DAY8.BOJ5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Dijkstra + BackTracking
 */

public class Main {

    static class Node{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static int N, M, start, end;
    static final int MAX = Integer.MAX_VALUE;
    static boolean flag = false;
    static ArrayList<Node>[] list;
    static List<Integer>[] nodes;
    static int[] dist;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            list = new ArrayList[N];
            dist = new int[N];
            visited = new boolean[N][N];
            nodes = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                nodes[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list[s].add(new Node(e, w));
            }

            dijkstra(start);
            remove(start, end);
            dijkstra(start);

            sb.append(dist[end] == MAX ? -1 : dist[end]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() {
        Arrays.fill(dist, MAX);
    }

    static void remove(int s, int d) {
        if(s==d) return;
        for(int nxt : nodes[d]) {
            if(!visited[nxt][d]) {
                visited[nxt][d] = true;
                remove(s, nxt);
            }
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.add(new Node(start, 0));
        init();
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int cur = node.end;
            if (node.weight > dist[cur]) continue;
            for (Node next : list[cur]) {
                if (!visited[cur][next.end]){
                    if (dist[next.end] > dist[cur] + next.weight) {
                        dist[next.end] = dist[cur] + next.weight;
                        nodes[next.end] = new ArrayList<>();
                        nodes[next.end].add(cur);
                        pq.add(new Node(next.end, dist[next.end]));
                    } else if (dist[next.end] == dist[cur] + next.weight) {
                        nodes[next.end].add(cur);
                    }
                }
            }
        }
    }
}

package SamsungSDSalgo.DAY8.BOJ3176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * LCA
 */

public class Main {
    static class Node{
        int end ,weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int N, K, D = 0;
    static ArrayList<Node>[] list;
    static Queue<Integer> queue;
    static boolean[] visited;
    static int[][] parents, minDist, maxDist; //2^K만큼 위에 있는 조상 노드
    static int[] depth;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        int tmp = 1;
        while (tmp <= N) { // 최대 depth 알아내기.
            tmp <<= 1;
            D++;
        }

        parents = new int[D][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        bfs();
        fill();

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arr = LCA(a, b);

            sb.append(arr[0]).append(" ").append(arr[1]);
            sb.append("\n");
        }
    }

    static int[] LCA(int a, int b) {
        // depth를 같게 만들기
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[b] - depth[a];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // depth의 차이를 비트 곱 연산으로 점핑
        for (int i = 0; i < D; i++) {
            if ((diff & (1 << i)) > 0) {
                min = Math.min(min, minDist[i][b]);
                max = Math.max(max, maxDist[i][b]);
                b = parents[i][b];
            }
        }

        if (a == b) return new int[] {min, max};

        // 2제곱으로 점핑하면서 공통 부모 search
        // 공통 부터가 다르면 해당 depth로 갱신(올리기)
        for (int d = D-1; d >= 0 ; d--) {
            if (parents[d][a] != parents[d][b]) {
                min = Math.min(min, Math.min(minDist[d][b], minDist[d][a]));
                max = Math.max(max, Math.max(maxDist[d][b], maxDist[d][a]));
                a = parents[d][a];
                b = parents[d][b];
            }
        }

        return new int[] {min, max};
    }

    static void bfs(){
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Node next : list[cur]) {
                if (!visited[next.end]) {
                    minDist[0][next.end] = next.weight; // 이해 필요
                    maxDist[0][next.end] = next.weight; // 이해 필요
                    parents[0][next.end] = cur;

                    visited[next.end] = true;
                    queue.add(next.end);
                    depth[next.end] = depth[cur] + 1;
                }
            }
        }
    }

    static void fill() {
        for (int i = 1; i < D; i++) {
            for (int j = 1; j < N + 1; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];

                // 이해 필요
                minDist[i][j] = Math.min(minDist[i-1][j], minDist[i-1][parents[i-1][j]]);
                maxDist[i][j] = Math.max(maxDist[i-1][j], maxDist[i-1][parents[i-1][j]]);
            }
        }
    }
}

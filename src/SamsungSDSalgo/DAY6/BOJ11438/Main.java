package SamsungSDSalgo.DAY6.BOJ11438;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * LCA
 */

public class Main {

    static int N, K = 0;
    static ArrayList<Integer>[] tree;
    static Queue<Integer> queue;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int tmp = 1;
        while (tmp <= N) { // 최대 depth 알아내기.
            tmp <<= 1;
            K++;
        }

        parent = new int[K][N + 1];
        depth = new int[N + 1]; // 각 노드별 깊이
        visited = new boolean[N + 1];

        queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        bfs(); // parent 배열 첫 줄 채우기
        fill();

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int LCA(int a, int b) {
        // 1. 깊이가 차이나면 깊이를 같게
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int gap = depth[b] - depth[a];
        for (int i = 0; i < K; i++) {
            if ((gap & (1 << i)) > 0) {
                b = parent[i][b];

            }
        }
        if (a == b) return a;

        // 2. 이분탐색으로 LCA 찾기
        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];

    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next :
                    tree[node]) {
                if (visited[next]) {
                    continue;
                }

                parent[0][next] = node;
                visited[next] = true;
                depth[next] = depth[node] + 1;
                queue.add(next);
            }
        }
    }

    static void fill() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j < N + 1; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }
}

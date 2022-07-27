package SamsungSDSalgo.DAY7.BOJ2458;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Inorder - Outorder
 */

public class Main {

    static int N, M, count;
    static ArrayList<Integer>[] list;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        nodes = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            nodes[i] = new Node();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        bfs();

        for (int i = 1; i < N + 1; i++) {
            if (nodes[i].inorder + nodes[i].outorder + 1 == N) {
                count++;
            }
        }
        System.out.println(count);

    }

    static void bfs() {
        for (int i = 1; i < N + 1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next :
                        list[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        nodes[i].outorder++;
                        nodes[next].inorder++;
                    }
                }
            }
        }
    }

    static class Node{
        int inorder;
        int outorder;
    }
}

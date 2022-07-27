package SamsungSDSalgo.DAY7.BOJ11657;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 벨만 포드
 */

public class Main {

    static int N, M;
    static ArrayList<Node>[] list;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new long[N + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1");
        }else{
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
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

    static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 갱신 작업을 반복복
       for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j < N + 1; j++) {
                for (Node next : list[j]) {
                    if (dist[j] == Integer.MAX_VALUE) break;

                    if (dist[next.end] > dist[j] + next.weight) {
                        dist[next.end] = dist[j] + next.weight;
                        update = true;
                    }
                }
            }
            // 더 이상 최단거리 갱신이 일어나지 않았을 경우 반복문을 종료.
            if (!update) return false;
       }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node next : list[i]) {
                    if (dist[i] == Integer.MAX_VALUE) break;

                    if (dist[next.end] > dist[i] + next.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

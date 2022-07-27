package SamsungSDSalgo.DAY8.BOJ3830;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static String query;
    static int[] parents;
    static long[] dist; // root까지 가중치의 합 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            // Union Find를 위한 parent 초기화
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }
            dist = new long[N + 1];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                query = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (Objects.equals(query, "!")){ // 무게 측정
                    long w = Long.parseLong(st.nextToken());

                    union(a, b, w);

                }else{ // 교수님 질문
                    if (find(a) != find(b)) sb.append("UNKNOWN").append("\n");
                    else{
                        sb.append(dist[b] - dist[a]).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b, long diff) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot){
            dist[bRoot] = dist[a] - dist[b] + diff;
            parents[bRoot] = aRoot;
        }

    }

    static int find(int vertex) {
        // 1. root 인 경우, 무게 0
        if (parents[vertex] == vertex) return vertex;
        // 2. root가 아닌 경우, root까지의 무게 갱신(더하기)
        int parent = find(parents[vertex]);
        dist[vertex] += dist[parents[vertex]];

        return parents[vertex] = parent;
    }
}

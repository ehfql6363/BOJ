package SamsungSDSalgo.DAY6.BOJ1717;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 그래프 합집합 - Disjoint Set
 */

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (c == 0) { // union
                union(a, b);
            }
            else if (c == 1){
                sb.append(findParents(a) == findParents(b) ? "YES" : "NO").append("\n");
            }else{
                continue;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int aRoot = findParents(a);
        int bRoot = findParents(b);

        if (aRoot != bRoot) {
            if (aRoot > bRoot) {
                parents[aRoot] = bRoot;
            }else{
                parents[bRoot] = aRoot;
            }
        }
    }
    static int findParents(int vertex){
        if (parents[vertex] == vertex) return vertex;
        else return parents[vertex] = findParents(parents[vertex]);
    }
}

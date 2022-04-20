package baekjoon;

import java.io.*;
import java.util.*;

class Node1916 implements Comparable<Node1916>{
    int e, w;
    public Node1916(int e, int w){
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Node1916 o) {
        return this.w - o.w;
    }
}

public class BOJ1916 {
    public static boolean[] visited;
    public static int[] dp; // 거리별 최소 가중치
    public static ArrayList<Node1916>[] sew;
    public static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        sew = new ArrayList[n+1];
        for (int i=0; i< sew.length; i++){
            sew[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        dp = new int[n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node1916 node = new Node1916(e, w);

            sew[s].add(node);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(String.valueOf(dp[end]));
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dijkstra() {
        PriorityQueue<Node1916> pq = new PriorityQueue<>();
        pq.add(new Node1916(start, 0));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        while(!pq.isEmpty()){
            Node1916 now = pq.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            //dp[now.e] = ?

            for(Node1916 next : sew[now.e]){
                if(dp[next.e] >= dp[now.e] + next.w){
                    dp[next.e] = dp[now.e] + next.w; // 해당 거리까지 가는 최소 값
                    pq.add(new Node1916(next.e, dp[next.e]));
                }
            }
        }
    }
}

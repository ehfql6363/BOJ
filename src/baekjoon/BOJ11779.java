package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ11779 {
    public static boolean[] visited;
    public static int n,m;
    public static ArrayList<Node>[] list;
    public static int[] dp;
    public static int[] road;
    public static class Node implements Comparable<Node>{
        int e, w;
        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
        }
        road = new int[n+1];
        visited = new boolean[n+1];
        dp = new int[n+1];
        Arrays.fill(dp, 1000000001);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        sb.append(dp[end]).append("\n");

        //역추적
        ArrayList<Integer> arr = new ArrayList<>();
        int num = end;
        while(num != 0){
            arr.add(num);
            num = road[num];
        }
        sb.append(arr.size()).append("\n");
        for(int i=arr.size()-1; i>=0; i--){
            sb.append(arr.get(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dp[start] = 0;
        road[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visited[now.e]) visited[now.e] = true;
            else continue;

            for(Node next : list[now.e]){
                if(dp[next.e] > dp[now.e] + next.w){ //<=도 가능 하지만 메모리 초과 뜸
                    dp[next.e] = dp[now.e] + next.w;
                    road[next.e] = now.e;
                    pq.add(new Node(next.e, dp[next.e]));
                }
            }
        }
    }
}
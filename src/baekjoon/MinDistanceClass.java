package baekjoon;

import java.io.*;
import java.util.*;

class NodeMDC implements Comparable<NodeMDC>{
    int end, weight;

    public NodeMDC(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(NodeMDC o) {
        return weight - o.weight;
    }
}

public class MinDistanceClass {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000;
    static int v,e,k;
    static List<NodeMDC>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start���� end�� ���� weight ����ġ
            list[start].add(new NodeMDC(end, weight));
        }

        StringBuilder sb = new StringBuilder();

        dijkstra(k);

        for(int i = 1; i <= v; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
       PriorityQueue<NodeMDC> queue = new PriorityQueue<>();
       boolean[] check = new boolean[v + 1];
       queue.add(new NodeMDC(start, 0));
       dist[start] = 0;

       while(!queue.isEmpty()){
           NodeMDC curNode = queue.poll();
           int cur = curNode.end;

           if(check[cur]) continue;
           check[cur] = true;

           for(NodeMDC node : list[cur]){
               if(dist[node.end] > dist[cur] + node.weight){
                   dist[node.end] = dist[cur] + node.weight;
                   queue.add(new NodeMDC(node.end, dist[node.end]));
               }
           }
       }
    }
}
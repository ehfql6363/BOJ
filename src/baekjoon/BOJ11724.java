package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static int cnt=0;

    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        parents = new int[n+1];

        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                cnt++;
                q.add(i);
                visited[i] = true;
                search(q);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void search(Queue<Integer> q){
        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : list[node]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    search(q);
                }
            }
        }
    }
}

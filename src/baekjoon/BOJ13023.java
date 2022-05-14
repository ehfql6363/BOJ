package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0; i<N; i++){
            if(ans == 1) break;
            dfs(i, 1);
        }

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
    public static void dfs(int start, int cnt){
        if(cnt == 5){
            ans = 1;
            return;
        }
        visited[start] = true;
        for(int i : arr[start]){
            if(!visited[i]){
                dfs(i, cnt+1);
            }
        }
        visited[start] = false;
    }
}

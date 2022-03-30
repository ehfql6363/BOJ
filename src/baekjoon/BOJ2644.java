package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    public static int ans = -1;
    public static boolean flag1, flag2 = false;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int conn = Integer.parseInt(br.readLine());
        for(int i=0; i<conn; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        tree(x, y, 0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void tree(int x, int y, int cnt){
        if(x == y) ans = cnt;

        visited[x] =true;
        for(int i : list[x]){
            if(!visited[i]){
                tree(i, y, cnt+1);
            }
        }
    }
}

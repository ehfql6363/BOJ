package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15686 {
    public static class Node {
        int row;
        int col;

        Node(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public static int N, K, ans;
    public static int MAX = Integer.MIN_VALUE;
    public static int[][] arr;
    public static ArrayList<Node> home;
    public static ArrayList<Node> chicken;
    public static boolean[] opened;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) home.add(new Node(i,j));
                if(arr[i][j] == 2) chicken.add(new Node(i,j));
            }
        }
        ans = Integer.MAX_VALUE;
        opened = new boolean[chicken.size()];

        dfs(0, 0);
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();

    }
    public static void dfs(int start, int depth){
        if(depth == K){
            int res = 0;

            for (Node node : home) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (opened[j]) {
                        int dist = Math.abs(node.row - chicken.get(j).row) + Math.abs(node.col - chicken.get(j).col);
                        tmp = Math.min(dist, tmp);
                    }
                }
                res += tmp;
            }
            ans = Math.min(res, ans);
        }

        for(int i=start; i< chicken.size(); i++){
            opened[i] = true;
            dfs(i+1, depth + 1);
            opened[i] = false;
        }
    }
}

package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static int test;
    public static int[][] color;
    public static boolean[][] visited;
    public static int price = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        test = Integer.parseInt(br.readLine());
        color = new int[test][3];
        visited = new boolean[test][3];

        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<3; i++){
            visited[0][i] = true;
            sum += color[0][i];
            dp(sum);
            sum = 0;
        }

    }
    public static void dp(int sum){
        for(int i=1; i<test; i++){
            if(!visited[i][0]){
                sum+=color[i][0];
                visited[i][0] = true;
            }
        }
    }
}

package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static int[][] color;
    public static boolean[][] visited;
    public static int price = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        color = new int[test][3];
        visited = new boolean[test][3];

        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int idx = 1;
        for(int i=0; i<3; i++){
            visited[0][i] = true;
            visited[1][i] = true;
            sum += color[0][i];

            dp(sum, idx);

            sum = 0;
            visited[0][i] = false;
            visited[1][i] = false;
        }

        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
        br.close();

    }
    public static void dp(int sum, int idx){
        if(idx == color.length) {
            price = Math.min(sum, price);
            return;
        }

        for(int i=0; i<3; i++){
            if(0 < idx && idx < color.length-1){
                if(!visited[idx][i]){
                    sum += color[idx][i];
                    visited[idx][i] = true;
                    visited[idx+1][i] = true;

                    dp(sum, idx+1);

                    visited[idx][i] = false;
                    visited[idx+1][i] = false;
                    sum -= color[idx][i];
                }
            }
            if(idx == color.length-1){
                if(!visited[idx][i]){
                    sum += color[idx][i];
                    visited[idx][i] = true;

                    dp(sum, idx+1);

                    visited[idx][i] = false;
                    sum -= color[idx][i];
                }
            }

        }
    }
}

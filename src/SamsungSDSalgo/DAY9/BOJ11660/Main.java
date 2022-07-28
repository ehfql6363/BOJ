package SamsungSDSalgo.DAY9.BOJ11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeDp();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            int ans = dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] +
                    dp[row1 - 1][col1 - 1];

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void makeDp(){
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                dp[r][c] = dp[r][c - 1] + dp[r - 1][c] + arr[r][c] - dp[r - 1][c - 1];
            }
        }
    }
}

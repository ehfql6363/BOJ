package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=1; i<n+1; i++){
            int num = Integer.parseInt(br.readLine());
            for(int j=num; j<dp.length; j++){
                dp[j] = dp[j] + dp[j - num];
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}

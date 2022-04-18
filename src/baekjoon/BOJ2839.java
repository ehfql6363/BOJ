package baekjoon;

import java.io.*;


public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i=0; i<dp.length; i++){
            if((i-dp[i])/3 > 0) dp[i] = (i-dp[i])/3;
        }
    }
}

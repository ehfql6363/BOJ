package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NormalBag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] W = new int[n+1];
        int[] V = new int[n+1];

        int[][] dp = new int[n+1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int weight=1; weight<=k; weight++){
                if(W[i] > weight)
                    dp[i][weight] = dp[i-1][weight];
                else
                    dp[i][weight] = Math.max(dp[i-1][weight], dp[i-1][weight-W[i]] + V[i]);
            }
        }

        System.out.println(dp[n][k]);
    }
}
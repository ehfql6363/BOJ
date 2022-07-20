package baekjoon;

import java.util.Scanner;

public class BOJ1932 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j=0; j<=i; j++){
                arr[i][j] = sc.nextInt();
                if (i == n-1) {
                    dp[i][j] = arr[i][j];
                }else{
                    dp[i][j] = -1;
                }
            }
        }

        sum(arr, dp, 0, 0);

        System.out.println(dp[0][0]);
    }

    static int sum(int[][] arr, int[][] dp, int depth, int index) {
        if(depth == n - 1) return dp[depth][index];

        if(dp[depth][index] == -1){
            dp[depth][index] = Math.max(sum(arr, dp, depth+1, index), sum(arr, dp, depth+1, index+1)) + arr[depth][index];
        }

        return dp[depth][index];
    }
}

package CodeForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P189A {
    public static boolean[] visited;
    public static int[] arr = new int[3];
    public static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ans = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bw.write(String.valueOf(dp(n, 0)));
        bw.flush();
        bw.close();
        br.close();

    }
    public static int dp(int n, int cnt){ //BottomUp
        if(n < 0) return -1;
        else if(n == 0) return cnt;

        if(visited[n]) return ans[n];
        visited[n] = true;

        int rest1 = dp(n - arr[0], cnt + 1);
        int rest2 = dp(n - arr[1], cnt + 1);
        int rest3 = dp(n - arr[2], cnt + 1);

        return ans[n] = Math.max(rest1, Math.max(rest2, rest3));
    }
}

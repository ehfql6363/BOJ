package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class DeathStar11811 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] ans = new int[n];
;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<n; j++){
                if(i == j) continue;
                ans[j] |= num[j];
            }
        }

        for(int i=0; i<n; i++){
            sb.append(ans[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

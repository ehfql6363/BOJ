package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        sb.append(min).append(" ").append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

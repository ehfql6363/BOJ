package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16987 {
    public static int N;
    public static int ANS = Integer.MIN_VALUE;
    public static int[] d;
    public static int[] w;
    public static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        d = new int[N];
        w = new int[N];
        broken = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        brute(0, 0);

        bw.write(String.valueOf(ANS == Integer.MIN_VALUE ? 0 : ANS));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void brute(int now, int cnt){
        if(now==N) return;
        if(d[now] <= 0) {
            brute(now+1, cnt);
            return;
        }
        for(int i=0; i<N; i++){
            if(now == i || d[i] <= 0) continue;
            int count = 0;

            d[now] -= w[i];
            d[i] -= w[now];

            if(d[now] <= 0){
                broken[now] = true;
                count++;
            }
            if(d[i]<=0){
                broken[i] = true;
                count++;
            }

            ANS = Math.max(ANS, cnt+count);
            brute(now+1, cnt+count);

            broken[now] = false;
            broken[i] = false;
            d[now] += w[i];
            d[i] += w[now];
        }
    }
}

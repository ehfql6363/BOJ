package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1107 {
//    public static int min = Integer.MAX_VALUE;
    public static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] dial = new boolean[10];

        Arrays.fill(dial, true);

        if(m != 0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                dial[Integer.parseInt(st.nextToken())] = false;
            }
        }

        for(int i=0; i<dial.length; i++){
            if(!dial[i]) continue;
            brute(dial, n, String.valueOf(i));
        }

        int ans = Math.min(Math.abs(100 - n), cnt);

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
    public static void brute(boolean[] dial, int n, String val){
        if(val.length() > String.valueOf(n).length()+1) return;

        int num = Integer.parseInt(val);
        cnt = Math.min(cnt, val.length()+Math.abs(num - n));

        for(int i=0; i<dial.length; i++){
            if(dial[i]){
                String temp = val+i;
                brute(dial, n, temp);
            }
        }
    }
}

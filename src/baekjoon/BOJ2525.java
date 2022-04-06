package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int plusMin = Integer.parseInt(br.readLine());

        int minute = m + plusMin;

        while(minute >= 60){
            minute -= 60;
            h += 1;
            while(h >= 24){
                h -= 24;
            }
        }

        bw.write(h + " " + minute);
        bw.flush();
        bw.close();
        br.close();
    }
}

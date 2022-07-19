package SamsungSDSalgo.DAY2.BOJ1072;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = (Y * 100) / X;
        if (Z >= 99) {
            bw.write(String.valueOf(-1));
        } else {
            long max = X;
            long min = 0;

            while (min < max) {
                long mid = (max + min) / 2;

                long rate = ((Y + mid) * 100) / (X + mid);

                if (rate > Z) max = mid;
                else if (rate == Z){
                    min = mid + 1;
                }
            }

            bw.write(String.valueOf(max));
        }
        bw.close();
        br.close();
    }
}
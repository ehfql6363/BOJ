package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18017 {
    public static int LIGHT = 299792458;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double v1 = Double.parseDouble(st.nextToken());
        double v2 = Double.parseDouble(st.nextToken());

        double v = (v1+v2) / (1 + (v1*v2)/Math.pow(LIGHT,2));
        bw.write(String.valueOf(v));
        bw.flush();
        bw.close();
        br.close();
    }
}

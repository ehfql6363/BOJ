package baekjoon.baekClass;

import java.io.*;

public class BOJ10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(str+"??!");
        bw.flush();
        bw.close();
        br.close();
    }
}

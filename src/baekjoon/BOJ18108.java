package baekjoon;

import java.io.*;

public class BOJ18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(y - 543));
        bw.flush();
        bw.close();
        br.close();
    }
}

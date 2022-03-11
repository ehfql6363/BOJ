package baekjoon.baekClass;

import java.io.*;

public class ASCIICode {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);
        int a = c;

        bw.write(String.valueOf(a));
        bw.flush();
        bw.close();
        br.close();
    }
}

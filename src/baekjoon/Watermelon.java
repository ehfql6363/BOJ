package baekjoon;

import java.io.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n % 4 == 0) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}

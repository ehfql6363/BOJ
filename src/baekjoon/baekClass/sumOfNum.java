package baekjoon.baekClass;

import java.io.*;

public class sumOfNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int sum = 0;
        for (int i=0; i<n; i++){
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}

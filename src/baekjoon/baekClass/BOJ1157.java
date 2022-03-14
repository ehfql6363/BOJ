package baekjoon.baekClass;

import java.io.*;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];
        int max = Integer.MIN_VALUE;
        char ans = '?';

        String a = br.readLine();
        String str = a.toUpperCase();

        for(int i=0; i<a.length(); i++){
            alpha[str.charAt(i) - 'A']++;
        }

        for(int i=0; i<alpha.length; i++){
            if(alpha[i] > max) ans = (char)(i + 65);
            else if(alpha[i] == max) ans = '?';
            System.out.print(alpha[i]+" ");
        }
        System.out.println();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

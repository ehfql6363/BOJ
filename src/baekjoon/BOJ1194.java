package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1194 {
    public static int[] rows = {-1, 0, 1, 0};
    public static int[] cols = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for(int i=0; i<arr.length; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        
    }
}

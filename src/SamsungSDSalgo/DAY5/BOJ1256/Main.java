package SamsungSDSalgo.DAY5.BOJ1256;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 조합론 - 이항계수 : x번째 글 찾기 ( 인덱스 트리 개념 사용 )
 */

public class Main {

    static String word = "";
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        arr = new long[n+m+1][m+1];
        makeBinoCoef(n + m, m, k);

        for (int i = 0; i < n + m + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        if (k > arr[n + m][m]) {
            bw.write(String.valueOf(-1));
        }else{
            search(n + m, m, k);
            bw.write(word);
        }
        bw.close();
        br.close();

    }
    static void makeBinoCoef(int n, int r, long k){
        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < r + 1; i++) {
            arr[i][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < r + 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                if (arr[i][j] >= k) arr[i][j] = k;
            }
        }
    }

    static void search(int n, int r, long k) {
        if (n == 0) return;

//        System.out.print((n-1) + " C " + r + " : " + arr[n - 1][r] + " | " + k + " -> ");
//        System.out.print(n + " C " + r + " -> ");
        if (arr[n - 1][r] >= k){
//            System.out.println("up");
            word += "a";
            arr[n - 1][r] = k;
            search(n - 1, r, k);
        }else{
//            System.out.println("down");
            word += "z";
            search(n-1, r-1, k - arr[n-1][r]);
        }
    }
}

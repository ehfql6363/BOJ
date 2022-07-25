package SamsungSDSalgo.DAY4.BOJ14476;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 유클리드 호제법 (누적)
 */

public class Main {
    static int[] arr;
    static int[] arc;
    static int[] desc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arc = new int[N];
        desc = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arc[0] = arr[0];
        for (int i = 1; i < N; i++) {
            arc[i] = gcd(arr[i], arc[i - 1]);
        }
        desc[N - 1] = arr[N - 1];
        for (int i = N-2; i >= 0 ; i--) {
            desc[i] = gcd(arr[i], desc[i + 1]);
        }

        int max = -1;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            // 0
            if (i == 0) {
                gcd = desc[1];
            }
            // N-1
            else if (i == N - 1) {
                gcd = arc[N - 2];
            }
            // 중간
            else{
                gcd = gcd(arc[i - 1], desc[i + 1]);
            }

            if (arr[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIdx = i;
            }
        }

        if (max == -1) {
            bw.write(String.valueOf(max));
        }else{
            bw.write(max + " " + arr[maxIdx]);
        }
        bw.close();
        br.close();

    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

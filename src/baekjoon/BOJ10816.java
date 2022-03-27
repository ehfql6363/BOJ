package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static int N, M;
    public static int[] cards;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(high(num) - low(num)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int low(int n) {
        int start = 0;
        int end = cards.length;

        while (start < end) {
            int mid = (end - start) / 2 + start;

            if (n <= cards[mid]) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static int high(int n) {
        int start = 0;
        int end = cards.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;

            if (n < cards[mid]) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
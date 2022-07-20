package SamsungSDSalgo.DAY2.BOJ1806;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int high = 0;
        int low = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;

        while (high < N) {
            if (sum >= S) {
                min = Math.min(min, high - low + 1);
                sum -= arr[low++];
            }
            else {
                sum += arr[++high];
            }
        }

        if (min == Integer.MAX_VALUE) bw.write(String.valueOf(0));
        else bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}

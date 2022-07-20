package SamsungSDSalgo.DAY2.BOJ2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int high = max;
        int low = 0;
        int ans = 0;

        while (high >= low) {
            int mid = (high + low) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid >= 0) {
                    sum += (arr[i] - mid);
                }
            }

            if (sum == M){
                ans = mid;
                break;
            }else if (sum > M) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

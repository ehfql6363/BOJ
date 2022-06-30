package baekjoon.samsungSDSProTest;

import java.io.*;
import java.util.*;

public class p1 {

    static int n, m, d;
    static int start, result;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int t=0; t<test; t++){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            result=0;

            int[] arr = new int[n * m];
            int[] counting = new int[100];
            int[] res = new int[n * m];

            int idx = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[idx] = Integer.parseInt(st.nextToken());
                    idx++;
                }
            }

            for(int i = 0; i < arr.length; i++) {
                counting[arr[i]]++;
            }

            for(int i = 1; i < counting.length; i++) {
                counting[i] += counting[i - 1];
            }

            for(int i = arr.length - 1; i >= 0; i--) {
                int value = arr[i];
                counting[value]--;
                res[counting[value]] = value;
            }

            start = n*m-1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < d; i++) {
                int oil = Integer.parseInt(st.nextToken());

                for (int j = 0; j < res.length; j++) {
                    res[j]++;
                }

                cut(res, oil, i);
            }

            sb.append("#").append(t + 1).append(" ").append(result);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void cut(int[] res, int oil, int day) {
        for (int i = 0; i < oil; i++) {
            if (start < 0) {
                start = (start + res.length) % res.length;
            }
            result += (res[start] - 1) * (day + 1);
            res[start] = 1;
            start--;
        }
    }
}

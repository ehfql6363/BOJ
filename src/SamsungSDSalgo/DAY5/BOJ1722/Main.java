package SamsungSDSalgo.DAY5.BOJ1722;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 조합론 - 인덱스 트리 개념 포함
 */

public class Main {

    static boolean[] visited;
    static long[] facArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        facArr = new long[N+1];
        facArr[0] = 1;

        factorial(N);

        st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());

        if (test == 1) { // 순열 구하기
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (target > facArr[N - i - 1]) {
                        target -= facArr[N - i - 1];
                    } else {
                        sb.append(j);
                        sb.append(" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb);

        } else if (test == 2) { // 순열의 순번 구하기
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < num[i]; j++) {
                    if (!visited[j]) {
                        result += facArr[N - i - 1];
                    }
                }
                visited[num[i]] = true;
            }
            System.out.println(result + 1);
        }
    }

    static void factorial(int N) {
        for (int i = 1; i < N+1; i++) {
            facArr[i] = facArr[i - 1] * i;
        }
    }
}

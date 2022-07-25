package SamsungSDSalgo.DAY4.BOJ3955;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 확장 유클리드 호제법
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        /**
         * X = 인당 나눠줄 사탕의 개수
         * Y = 사탕 봉지의 수
         * A * X + 1 = B * Y
         * Ax + By = C의 형태로 변환
         * -Ax + By = 1
         * A(-x) + By = 1 로 변환
         */

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            // 1. 해 검증
            // D = gcd(A, B) = egcd(A, B).r
            // Ax + By = C 일때 C % D == 0 이어야 해를 가질 수 있음 : 베주 항등식
            // C % D != 0 -> 해가 없음

            EGResult init = extendedGCD(a, b);
            if (init.r != 1) {
                sb.append("IMPOSSIBLE").append("\n");
            }
            else{
                // 2. 초기 해 구하기
                // x0 = s * C / D
                // y0 = t * C / D
                long x0 = init.s;
                long y0 = init.t;

                // 3. 일반해 구하기
                // x = x0 + B / D * k
                // y = y0 - A / D * k

                //while  <- k ->

                // 4. k의 범위
                // x < 0
                // x0 + B * k < 0
                // k < - x0 / B

                // 0 < y <= 1e9
                // 0 < y0 - A * k <= 1e9
                // -y0 < -A * k <= 1e9 - y0
                // ( y0 - 1e9 ) / A <= k < y0 / A

                // ( y0 - 1e9 ) / A <= k < y0 / A
                //                     k < - x0 / B

                // 5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.

                long kFromY = (long) Math.ceil((double) y0 / (double) a) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) b) - 1;
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) a);
                if (kLimitFromY <= k) {
                    sb.append(y0 - a * k).append("\n");
                }else{
                    sb.append("IMPOSSIBLE").append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static EGResult extendedGCD(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while(r1 != 0){
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }

        return new EGResult(s0, t0, r0);
    }
    static class EGResult{
        long s;
        long t;
        long r;

        public EGResult(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}

package SamsungSDSalgo.DAY5.BOJ1837;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 정수론 - 소수
 */

public class Main {

    static int K;
    static String P;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[K+1];
        findPrime();

        boolean check = true;
        for (int i = 2; i < isNotPrime.length; i++) {
            if (i >= K) break;
            if (divide(i)) {
                check = false;
                bw.write("BAD "+i);
                break;
            }
        }

        if (check) bw.write("GOOD");
        bw.close();
        br.close();
    }
    static void findPrime(){
        for (int i = 2; i <= K; i++) {
            if (!isNotPrime[i]){
                for (int j = i * 2; j <= K; j += i) { //소수가 아닌 수 true 작업
                    if (!isNotPrime[j]) isNotPrime[j] = true; // 소수인데 아직 체크되어 있지 않으면
                }
            }
        }
    }

    static boolean divide(int i){

        int leftover = -1;
        if (!isNotPrime[i]) {
            leftover = 0;
            for (int j = 0; j < P.length(); j++) {
                int subNum = P.charAt(j) - '0';
                int num = leftover * 10 + subNum;
                leftover = num % i;
            }
        }
        return leftover == 0;
    }
}

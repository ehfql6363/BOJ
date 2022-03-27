package baekjoon;

import java.io.*;

public class InterestingPrime2023 {
    public static int N;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i=2; i<10; i++){
            searchPrime(i);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void searchPrime(int a){
        if(N == 1){
            for(int i=1; i<a; i++) {
                if (i == 1) continue;
                else if (a % i == 0) {
                    return;
                }
            }
            sb.append(a).append("\n");
        }else {
            for (int i = 1; i < a; i++) {
                if (i == 1) continue;
                else if (a % i == 0) {
                    return;
                }
            }
            for (int i = 1; i < 10; i++) {
                int num;
                if (i % 2 == 0 || i % 5 == 0) {
                    continue;
                } else {
                    num = a * 10 + i;
                }
                if ((int) (Math.log10(num) + 1) == N) {
                    boolean flag = false;
                    for (int j = 1; j < num; j++) {
                        if (j == 1) continue;
                        else if (num % j == 0) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        sb.append(num).append("\n");
                    }
                } else {
                    searchPrime(num);
                }
            }
        }
    }
}
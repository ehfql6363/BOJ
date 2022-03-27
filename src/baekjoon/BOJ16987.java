package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16987 {
    public static int N;
    public static int CNT = 0;
    public static int ANS = Integer.MIN_VALUE;
    public static int[] d;
    public static int[] w;
    public static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        d = new int[N];
        w = new int[N];
        broken = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        brute(0);

//        bw.write(String.valueOf(ANS));
//        bw.flush();
        bw.close();
        br.close();
    }
    public static void brute(int a){
        System.out.println("-=-=");
        if(!broken[a]){
            for(int i=a+1; i<N; i++){
                int eggA = d[a] - w[i];
                int eggI = d[i] - w[a];

                System.out.println(a);
                if(eggA <= 0) {
                    broken[a] = true;
                    System.out.println(a+ "/" + i);
                    CNT++;
                }
                if(eggI <= 0){
                    broken[i] = true;
                    System.out.println(a+ "/" + i);
                    CNT++;
                }

                if(broken[a]) {
                    System.out.println("==");
                    brute(i);
                }
                else d[a] = eggA;
            }
            System.out.println(CNT);
            ANS = Math.max(ANS, CNT);
            System.out.println(ANS);
            CNT = 0;
            System.out.println("-----------------");
        }
    }
}

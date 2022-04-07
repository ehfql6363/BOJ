package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1016 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] prime = new boolean[1000001];
        boolean[] arr = new boolean[(int)(max-min+1)];
        Arrays.fill(prime,true);
        prime[1] = false;

        eratos(prime); //합성수는 false로 채움

        for(long i = 2; i*i<=max; i++){
            if(!prime[(int)i]) continue;

            long pow = i*i;
            for(long j=min/pow + (min % pow != 0 ? 1 : 0); j*pow<=max; j++){
                if(!arr[(int)(j * pow - min)]) arr[(int)(j*pow-min)] = true;
            }
        }

        int cnt = 0;
        for(long i = min; i<=max; i++){
            if(!arr[(int)(i-min)]) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void eratos(boolean[] prime){
        for(int i=2; i< prime.length; i++){
            if(prime[i]){
                for(int j=2; i*j< prime.length; j++){
                    prime[i*j] = true;
                }
            }
        }
    }
}

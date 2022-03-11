package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Slime14698 {
    public static BigInteger SUM = BigInteger.valueOf(1);
    public static BigInteger DIVIDE = BigInteger.valueOf(1000000007);
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<BigInteger> pq = new PriorityQueue<BigInteger>();

        int item = Integer.parseInt(br.readLine());
        while(item > 0){
            int slime = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<slime; i++){
                pq.offer(BigInteger.valueOf(Long.parseLong(st.nextToken())));
            }

            Com(pq);

            sb.append(SUM.mod(DIVIDE)).append("\n");

            SUM = BigInteger.valueOf(1);
            pq.clear();
            item--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Com(PriorityQueue<BigInteger> pq){
        BigInteger a = pq.poll();
        if(pq.isEmpty()) return;
        BigInteger b = pq.poll();

        BigInteger mul = a.multiply(b);

        pq.offer(mul);
        SUM = SUM.multiply(mul);

        Com(pq);
    }
}

package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Intern1946 {
    public static int[] interview;
    public static int COUNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        int deadLine = Integer.MAX_VALUE;
        while(test > 0){
            int size = Integer.parseInt(br.readLine());
            interview = new int[size];

            for(int i=0; i<interview.length; i++){
                st = new StringTokenizer(br.readLine());
                interview[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }

            while(deadLine > 1){
                for(int i=0; i<interview.length; i++){
                    if(interview[i] < deadLine){
                        deadLine = interview[i];
                        COUNT++;

                        if(deadLine == 1) break;
                    }
                }
            }

            sb.append(COUNT).append("\n");
            COUNT = 0;
            deadLine = Integer.MAX_VALUE;
            test--;

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
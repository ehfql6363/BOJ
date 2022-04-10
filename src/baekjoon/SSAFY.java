package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class SSAFY {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            int[] month = new int[12];
            int[] price = new int[4];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<price.length; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<month.length; i++){
                month[i] = Integer.parseInt(st.nextToken());
            }


        }
    }
    public static void func(int[] month, int[] price){
        for(int i=0; i<month.length; i++){
            if(month[i] != 0){
                

            }
        }
    }
}

package baekjoon.baekClass;

import java.io.*;

public class Maximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }
        sb.append(max).append("\n").append(maxIdx+1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

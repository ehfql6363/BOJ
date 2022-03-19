package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class Syllable {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int[] arr = new int[8];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check(arr);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void check(int[] arr){
        int cnt = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]+1 == arr[i+1]) cnt++;
            else if(arr[i] == arr[i+1]+1) cnt--;
        }
        if(cnt == 7) sb.append("ascending");
        else if(cnt == -7) sb.append("descending");
        else sb.append("mixed");

        return;
    }
}

package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cfPaintingFence {
    public static int stroke = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int item = Integer.parseInt(br.readLine());
        int[] fence = new int[item];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< fence.length; i++){
            fence[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        boolean check = false;
        while(true){
            if(idx == fence.length){
                if(check){
                    check = false;
                    stroke++;
                }
                idx = 0;
                if(painted(fence)) break;
            }

            if(fence[idx] != 0) {
                check = true;
                fence[idx]--;
                idx++;
            }
            else{
                if(check) {
                    stroke++;
                    check = false;
                }
                idx++;
            }
        }
        int ans = fence.length >= stroke ? stroke : fence.length;
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean painted(int[] arr){
        for (int j : arr) {
            if (j != 0) return false;
        }
        return true;
    }
}

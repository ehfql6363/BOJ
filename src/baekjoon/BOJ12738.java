package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12738 {
    public static int[] lis;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        lis = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        lis[len] = arr[0];

        for(int i=1; i<arr.length; i++){
            if(lis[len] < arr[i]){
                len++;
                lis[len] = arr[i];
            }else{
                int idx = getIndex(0, len, arr[i]);
                lis[idx] = arr[i];
            }
        }

        bw.write(String.valueOf(len+1));
        bw.close();
        br.close();
    }
    public static int getIndex(int left, int right, int val){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(lis[mid] < val) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}

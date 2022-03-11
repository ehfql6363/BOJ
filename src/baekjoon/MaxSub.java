package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MaxSub {
    public static boolean[] visited;
    public static int[] arr;
    public static int sum = 0;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        arr = new int[size];
        visited = new boolean[size];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<arr.length; i++){
            brute(i);
        }


        System.out.println(max);
    }
    public static void brute(int a){
        visited[a] = true;
        int cal = 0;
        for(int i=0; i< arr.length; i++) {
            if (!visited[i]) {
                cal = Math.abs(arr[a] - arr[i]);
                sum += cal;
                max = Math.max(sum, max);
                brute(i);
                sum -= cal;
                visited[i] = false;
            }
        }
        visited[a] = false;
    }
}
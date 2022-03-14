package baekjoon;

import java.io.*;

public class BOJ1747 {
    public static int N;
    public static boolean flag1 = false;
    public static boolean flag2 = false;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        brute();

        bw.flush();
        bw.close();
        br.close();
    }
    public static void brute() throws IOException {
        while(true){
            if(N == 1) N++;
            palindrome();
            prime();
            if(flag1 && flag2) {
                bw.write(String.valueOf(N));
                return;
            }
        }
    }
    public static void palindrome(){
        while(true){
            String strN = String.valueOf(N);
            char[] arr = new char[strN.length()];

            for(int i=0; i<arr.length; i++){
                arr[i] = String.valueOf(N).charAt(i);
            }

            int left = 0;
            int right = arr.length - 1;

            for(int i =0; i<arr.length/2 + 1; i++){
                if(left >= right) {
                    flag1 = true;
                    return;
                }
                if(arr[left] != arr[right]) {
                    N++;
                    break;
                }
                left++;
                right--;
            }
        }
    }
    public static void prime(){
        for(int i=2; i<=Math.sqrt(N); i++){
            if(N % i == 0) {
                N++;
                return;
            }
        }
        flag2 = true;
    }
}

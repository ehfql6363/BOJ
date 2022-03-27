package baekjoon;

import java.io.*;

public class SuperMario2851 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i=0; i<10; i++){
            if(ans + arr[i] <= 100){
                ans += arr[i];
            }else{
                if(ans + arr[i] - 100 <= 100 - ans){
                    ans += arr[i];
                    break;
                }else break;
            }
        }
        System.out.println(ans);
    }
}

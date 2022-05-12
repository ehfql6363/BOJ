package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class kakao2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int num=0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i< queue1.length; i++){
            arr.add(queue1[i]);
            num += queue1[i];
        }
        for(int i=0; i< queue2.length; i++){
            arr.add(queue2[i]);
            num += queue2[i];
        }
        if (num % 2 == 0) num /= 2;
        else {
            bw.write("-1");
            bw.flush();
            return;
        }
        //else return -1;


        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            int a = 0;
            int idx = i;

            while(a <= num && idx < arr.size()){
                a += arr.get(idx);

                if(a == num){
                    if(i > queue1.length){
                        sum = queue1.length+ (idx-i+1) + (i- queue1.length)*2;
                        ans = Math.min(sum, ans);
                        break;
                    }else {
                        sum = i + 1;
                        ans = Math.min(sum, ans);
                        break;
                    }
                }
                if(a > num) break;
                idx++;
            }
        }
        if(ans == Integer.MAX_VALUE) sb.append("-1");
        else sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}

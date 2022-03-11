package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class AthenB16953 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Integer.parseInt(st.nextToken());
        long goal = Integer.parseInt(st.nextToken());
        int cnt = 0;

        if(start > goal) sb.append(-1);
        while (start != goal){
            String str = String.valueOf(goal);
            if(goal % 2 != 0 && str.charAt(str.length()-1) != '1'){
                cnt = -2;
                break;
            }

            if(goal % 2 == 0){
                goal /= 2;
            }else if(str.charAt(str.length()-1) == '1'){
                goal /= 10;
            }

            if(start > goal) {
                cnt = -2;
                break;
            }
            cnt++;
        }

        sb.append(cnt+1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

package baekjoon.baekClass;

import java.io.*;

public class OXQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        while (test>0){
            String str = br.readLine();

            int cnt = 0;
            int sum = 0;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == 'O') {
                    cnt++;
                    sum += cnt;
                }
                else cnt = 0;
            }
            sb.append(sum).append("\n");

            test--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

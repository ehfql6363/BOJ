package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class StringRepeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        while(test > 0){
            st = new StringTokenizer(br.readLine());
            int re = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i=0; i<str.length(); i++){
                for(int j=0; j<re; j++){
                    sb.append(str.charAt(i));
                }
            }
            sb.append("\n");

            test--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
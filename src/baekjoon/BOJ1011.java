package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        while(test-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int count;

            int dist = e - s;
            int max = (int) Math.sqrt(dist);

            if(max == Math.sqrt(dist)) count = 2 * max - 1;
            else if(dist <= max * max + max) count = 2*max;
            else count = 2 * max + 1;

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

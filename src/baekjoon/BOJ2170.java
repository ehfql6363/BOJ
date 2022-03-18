package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());
        long[][] dot = new long[line][2];

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot, (o1, o2) -> {
            if(o1[0] == o2[0]) return (int) (o1[1] - o2[1]);
            return (int) (o1[0] - o2[0]);
        });

        long end = dot[0][1];
        long dis = dot[0][1] - dot[0][0];

        for(int i=1; i<line; i++){
            if(end >= dot[i][1]) continue;
            if(end < dot[i][1]){
                if(end <= dot[i][0]) dis += dot[i][1] - dot[i][0];
                else dis += dot[i][1] - end;
                end = dot[i][1];
            }
        }

        bw.write(String.valueOf(dis));
        bw.flush();
        bw.close();
        br.close();
    }
}

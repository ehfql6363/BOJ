package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
    public static PriorityQueue<Integer> endQ = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] table = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        endQ.add(table[0][1]);

        for(int i=1; i<table.length; i++){
            if(endQ.peek() <= table[i][0]) endQ.poll();
            endQ.add(table[i][1]);
        }

        bw.write(String.valueOf(endQ.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
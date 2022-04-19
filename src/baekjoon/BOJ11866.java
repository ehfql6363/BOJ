package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<n+1; i++){
            q.add(i);
        }

        sb.append("<");
        sol(q, k);
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void sol(Queue<Integer> q, int k){
        Queue<Integer> copyQ = new LinkedList<>();
        int del = k;
        while(del > q.size()) del -= q.size();
        int idx = 0;
        while(!q.isEmpty()){
            idx++;
            if(idx == del) {
                sb.append(q.poll());
                break;
            }
            q.add(q.poll());
        }
        while(!q.isEmpty()){
            copyQ.add(q.poll());
        }

        if(copyQ.isEmpty()) return;
        sb.append(", ");
        sol(copyQ, k);
    }
}

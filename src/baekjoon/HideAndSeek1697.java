package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek1697 {
    public static int GOAL;
    public static Queue<Integer> q;
    public static int[] DEPTH = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        q = new LinkedList<>();

        int initial = Integer.parseInt(st.nextToken());
        GOAL = Integer.parseInt(st.nextToken());

        if(initial == GOAL){
            bw.write(String.valueOf(0));
        }
        else {
            bfs(initial);

            bw.write(String.valueOf(DEPTH[GOAL] - 1));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(int num){
        q.offer(num);
        DEPTH[num] = 1;

        while(!q.isEmpty()){
            int a = q.poll();

            for(int i=0; i<3; i++){
                int n;

                if(i == 0) n = a - 1;
                else if(i == 1) n = a + 1;
                else n = 2 * a;

                if(n == GOAL) {
                    DEPTH[n] = DEPTH[a] + 1;
                    return;
                }

                if(n >= 0 && n < DEPTH.length && DEPTH[n] == 0){
                    q.offer(n);
                    DEPTH[n] = DEPTH[a] + 1;
                }
            }
        }
    }
}

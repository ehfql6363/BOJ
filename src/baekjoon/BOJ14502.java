package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    public static class Virus{
        int row, col;
        Virus(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int N,M;
    public static int[] rows = {-1, 0, 1, 0};
    public static int[] cols = {0, -1, 0, 1};
    public static int MAX = Integer.MIN_VALUE;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(String.valueOf(MAX));
        bw.close();
        br.close();

    }
    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(depth+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    public static void bfs(){
        Queue<Virus> q = new LinkedList<>();
        int[][] virusArr = new int[N][M];

        for(int i=0; i<N; i++){
            if (M >= 0) System.arraycopy(arr[i], 0, virusArr[i], 0, M);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(virusArr[i][j] == 2) q.add(new Virus(i, j));
            }
        }

        while(!q.isEmpty()){
            Virus vi = q.poll();

            for(int i=0; i<4; i++){
                int nextRow = vi.row + rows[i];
                int nextCol = vi.col + cols[i];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M){
                    if(virusArr[nextRow][nextCol] == 0){
                        virusArr[nextRow][nextCol] = 2;
                        q.add(new Virus(nextRow, nextCol));
                    }
                }
            }
        }
        counting(virusArr);
    }
    public static void counting(int[][] virusArr){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(virusArr[i][j] == 0) count++;
            }
        }
        if(count > MAX) MAX = count;
    }
}

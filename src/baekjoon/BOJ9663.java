package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ9663 {
    public static int N;
    public static int CNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        if(N == 1) CNT = 1;

        int[][] chess = new int[N][N];

        for(int i=0; i<N; i++){
            chess[0][i] = 1;

            NQueen(chess, 1);

            for(int[] a : chess){
                Arrays.fill(a, 0);
            }
        }

        bw.write(String.valueOf(CNT));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void NQueen(int[][] chess, int rows){
        for(int i=0; i<N; i++){
            if(rowsCheck(chess, rows, i) && diagFill(chess, rows, i)){
                chess[rows][i] = 1;

                if(rows == N-1) {
                    CNT++;
                    return;
                }

                NQueen(chess, rows+1);
                chess[rows][i] = 0;
            }
        }
    }
    public static boolean rowsCheck(int[][] chess, int rows, int idx){
        for(int i=rows-1; i>=0; i--){
            if(chess[i][idx] == 1) return false;
        }
        return true;
    }
    public static boolean diagFill(int[][] chess, int rows, int idx){
        int x=0;
        while(rows > 0 || idx - x >= 0 || idx + x < N){
            rows--;
            x++;
            if(rows >= 0 && idx - x >= 0){
                if(chess[rows][idx - x] == 1) return false;
            }
            if(rows >= 0 && idx + x < N){
                if(chess[rows][idx + x] == 1) return false;
            }
        }
        return true;
    }
}

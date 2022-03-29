package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14500 {
    public static boolean[][] visited;
    public static int[][] arr;
    public static int[] rows = {-1, 0, 1, 0};
    public static int[] cols = {0, -1, 0, 1};

    public static int n, m;
    public static int SUM = 0;
    public static int MAX = Integer.MIN_VALUE;
    public static int CNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                brute(i, j);
                fxxkCheck(i, j);
            }
        }

        bw.write(String.valueOf(MAX));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void brute(int row, int col){

        if(CNT == 4) {
            MAX = Math.max(SUM, MAX);
            return;
        }

        for(int i=0; i<4; i++){
            int nCol = col + cols[i];
            int nRow = row + rows[i];

            if(nCol < 0 || nRow < 0 || nRow >= arr.length || nCol >= arr[0].length || visited[nRow][nCol]){
                continue;
            }

            visited[row][col] = true;
            SUM += arr[row][col];
            CNT++;

            brute(nRow, nCol);

            CNT--;
            visited[row][col] = false;
            SUM -= arr[row][col];
        }
    }
    static void fxxkCheck(int y, int x) {
        if (y < n - 2 && x < m - 1)
            MAX = Math.max(MAX, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            MAX = Math.max(MAX, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            MAX = Math.max(MAX, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            MAX = Math.max(MAX, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1]);
    }
}

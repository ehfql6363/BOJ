package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1012 {
    public static int n, m;
    public static boolean[][] arr;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());


        while(test>0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new boolean[n][m];
            visited = new boolean[n][m];

            while (k >0){
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());

                arr[i][j] = true;
                k--;
            }

            int count = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && arr[i][j]){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(count).append("\n");
            test--;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    public static void dfs(int row, int col){
        if(!visited[row][col]){
            visited[row][col] = true;
            if(check(row - 1,col)) dfs(row-1, col);
            if (check(row, col - 1)) dfs(row, col-1);
            if (check(row + 1, col)) dfs(row+1, col);
            if (check(row, col + 1)) dfs(row, col+1);
        }
    }
    public static boolean check(int row, int col){
        if(row >= 0 && row < n && col >= 0 && col < m){
            return arr[row][col];
        }else return false;
    }
}

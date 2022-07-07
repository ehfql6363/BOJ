package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026 {

    static int n;
    static boolean[][] visited;
    static int[] rows = {-1, 1, 0, 0};
    static int[] cols = {0, 0, -1, 1};
    static int[] count = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int t = 0;
        char[][] grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        while(t < 2){
            Queue<Character> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        queue.add(grid[i][j]);
                        dfs(queue, grid, t, i, j);
                        count[t]++;
                    }
                }
            }

            for (int i=0; i< n; i++){
                Arrays.fill(visited[i], false);
            }
            t++;
        }
        System.out.println(count[0] + " " + count[1]);
        sc.close();
    }
    static void dfs(Queue<Character> queue, char[][] grid, int t, int row, int col){
        char temp = queue.poll();
        visited[row][col] = true;

        if(t==0){
            for(int i=0; i<4; i++){
                int dr = row+rows[i];
                int dc = col+cols[i];

                if(dr >= 0 && dc >= 0 && dr < n && dc < n){
                    if(!visited[dr][dc] && grid[dr][dc] == temp){
                        queue.add(grid[dr][dc]);
                        dfs(queue, grid, t, dr, dc);
                    }
                }
            }
        }else if (t == 1){
            if (temp == 'G') temp = 'R';
            for(int i=0; i<4; i++){
                int dr = row+rows[i];
                int dc = col+cols[i];

                if(dr >= 0 && dc >= 0 && dr < n && dc < n){
                    char val = grid[dr][dc];
                    if (val == 'G') val = 'R';
                    if(!visited[dr][dc] && val == temp){
                        queue.add(grid[dr][dc]);
                        dfs(queue, grid, t, dr, dc);
                    }
                }
            }
        }
    }
}

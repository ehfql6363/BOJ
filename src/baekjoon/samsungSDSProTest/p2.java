package baekjoon.samsungSDSProTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class p2 {

    static int n, m, r, k;
    static int count;
    static int goalRow, goalCol;
    static int[] rows = {-1, 1, 0, 0};
    static int[] cols = {0, 0, -1, 1};
    static boolean[][] visited;

    static class Node implements Comparable<Node>{
        int row, col;

        private Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Node o) {
            return ((row-r)+(col-k)) - ((o.row - r)+(o.col -k));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken()) - 1;
            k = Integer.parseInt(st.nextToken()) - 1;

            count = Integer.MAX_VALUE;

            ArrayList<Node> arr = new ArrayList<>();
            String[][] map = new String[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();

                for (int j = 0; j < map[i].length; j++) {
                    char[] strArr = str.toCharArray();
                    if(Objects.equals(strArr[j], 'A') || Objects.equals(strArr[j], 'B') || Objects.equals(strArr[j], 'C')){
                        arr.add(new Node(i,j));

                    }
                    if(Objects.equals(strArr[j],'S')){
                        goalRow = i;
                        goalCol = j;
                    }
                    map[i][j] = String.valueOf(strArr[j]);
                }
            }
            /*for (Node node : arr) {
                System.out.println("(" + node.row+", "+node.col+")");
            }*/

            visited[r][k] = true;
            dfs(map, arr, r, k, 0, 0);
            visited[r][k] = false;


            sb.append("#").append(t).append(" ").append(count);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(String[][] map, ArrayList<Node> arr, int ro, int co, int idx, int sum) {
        if (ro == arr.get(idx).row && co == arr.get(idx).col) {
            System.out.print("("+arr.get(idx).row+", "+arr.get(idx).col+")");
            System.out.println(" idx = "+idx+" sum = "+sum);
            idx++;
            if (idx == 3) {
                sum += Math.abs(ro - goalRow) + Math.abs(co - goalCol);
                System.out.println("done");
                System.out.println("sum"+sum);
                count = Math.min(sum, count);
                sum -= Math.abs(ro - goalRow) + Math.abs(co - goalCol);
                return;
            }
        }

        for (int i = 0; i < rows.length; i++) {
            int dr = ro + rows[i];
            int dc = co + cols[i];

            if(dr >= 0 && dc >= 0 && dr < n && dc < m && !visited[dr][dc]){
                if(!Objects.equals(map[dr][dc], "X") && !Objects.equals(map[dr][dc], "S") && idx != 3){
                    visited[dr][dc] = true;
                    dfs(map, arr, dr, dc, idx, sum + 1);
                    visited[dr][dc] = false;
                }
            }
        }
    }
}

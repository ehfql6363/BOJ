package SamsungSDSalgo.DAY1.BOJ3055;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {

    static int R, C;
    static int ans = Integer.MAX_VALUE;

    static int[] rows = {-1, 1, 0, 0};
    static int[] cols = {0, 0, -1, 1};
    static char[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int[][] count;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/SamsungSDSalgo/DAY1/BOJ3055/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        count = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j]=='S') {
                    queue.add(new int[]{i, j, 0});// {row, col, time}
                }else if(map[i][j]=='*'){
                    water.add(new int[]{i,j});
                }
            }
        }
        bfs();

        System.out.println(ans == Integer.MAX_VALUE? "KAKTUS" : ans);
    }

    static void bfs() {
        /*
        1. 큐에서 꺼내옴 ->
        2. 목적지인가?
        3. 연결된 곳 순회
            4. 갈 수 있는가?
                5. 체크인
                6. 큐에 넣음
        */
        while(!queue.isEmpty()){
            //물 이동
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] w = water.poll();
                int r = w[0];
                int c = w[1];
                for (int j = 0; j < 4; j++) {
                    int dr = rows[j] + r;
                    int dc = cols[j] + c;

                    if(dr >= 0 && dc >= 0 && dr < R && dc < C){
                        if (map[dr][dc] == '.') {
                            map[dr][dc] = '*';
                            water.add(new int[]{dr, dc});
                        }
                    }
                }
            }

            //고슴도치 이동
            len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] q = queue.poll();
                int r = q[0];
                int c = q[1];
                int minute = q[2];

                for (int j = 0; j < 4; j++) {
                    int dr = rows[j] + r;
                    int dc = cols[j] + c;

                    if(dr >= 0 && dc >= 0 && dr < R && dc < C){
                        if(map[dr][dc] == 'D'){
                            ans = Math.min(ans, minute + 1);

                        } else if (map[dr][dc] == '.') {
                            map[dr][dc] = 'S';
                            queue.add(new int[]{dr, dc, minute + 1});
                        }
                    }
                }
            }
        }
    }
}

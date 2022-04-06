package baekjoon.baekClass;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static int[][] color;
    public static boolean[][] visited;
    public static int[][] price;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        color = new int[test][3];
        visited = new boolean[test][3];
        price = new int[test][3];

        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        System.arraycopy(color[0], 0, price[0], 0, 3);

        dp(1);

        int ans = Math.min(Math.min(price[test-1][0], price[test-1][1]), price[test-1][2]);

//        for(int i=0; i<color.length; i++){
//            for(int j=0; j<3; j++){
//                System.out.print(price[i][j]+" ");
//            }
//            System.out.println();
//        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }
    public static void dp(int lv){
        if(lv == color.length) return;

        price[lv][0] = Math.min(price[lv-1][1], price[lv-1][2]) + color[lv][0];
        price[lv][1] = Math.min(price[lv-1][0], price[lv-1][2]) + color[lv][1];
        price[lv][2] = Math.min(price[lv-1][0], price[lv-1][1]) + color[lv][2];

        dp(lv+1);
    }
}

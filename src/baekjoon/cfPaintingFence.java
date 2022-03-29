package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class cfPaintingFence {
    public static int[] fence;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int item = Integer.parseInt(br.readLine());
        fence = new int[item];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< fence.length; i++){
            fence[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(painting(0, item-1)));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int painting(int start, int end){
        int st;
        int en;
        int hor;
        int ver = end - start + 1;
        int min = Integer.MAX_VALUE;

        for(int i=start; i<=end; i++){
            min = Math.min(min, fence[i]);
        }
        for(int i=start; i<=end; i++){
            fence[i] -= min;
        }
        hor = min;

        for(int i=start; i<=end;){
            if(fence[i] == 0) i++;
            else{
                st = i;
                en = st;
                while(en <= end && fence[en] != 0) en++;
                hor += painting(st, en-1);
                i = en;
            }
        }
        return Math.min(hor, ver);
    }
}

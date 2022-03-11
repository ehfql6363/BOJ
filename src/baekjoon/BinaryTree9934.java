package baekjoon;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinaryTree9934 {
    public static int[] arr;
    public static int[][] depthArr;
    public static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        arr = new int[(int)(Math.pow(2, k)) - 1];
        depthArr = new int[k+1][(int)Math.pow(2, k-1)];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree(0, arr.length-1,  1);

        for(int i=1; i<k+1; i++){
            for(int j=0; j<(int)Math.pow(2, i-1); j++){
                sb.append(depthArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void tree(int start, int end, int depth){
        if(end - start == 0){
            for(int i=0; i<(int)Math.pow(2, depth-1); i++){
                if(depthArr[depth][i] == 0){
                    depthArr[depth][i] = arr[start];
                    return;
                }
            }
        }

        int mid = start + (end - start)/2;
        for(int i=0; i<(int)Math.pow(2, depth-1); i++){
            if(depthArr[depth][i] == 0){
                depthArr[depth][i] = arr[mid];
                break;
            }
        }

        tree(start, mid - 1, depth + 1);
        tree(mid + 1, end, depth + 1);
    }
}
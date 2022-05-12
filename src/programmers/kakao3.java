package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class kakao3 {
    public static class Node{
        int e, w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    public static int[] gates = {1,3};
//    public static int[] gates = {3,7};
    public static int[] summits = {5};
//    public static int[] summits = {1,5};
    public static boolean[] visited = new boolean[50001];
    public static int[] result = new int[2];
    public static int start;
    public static int intensity;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = 6;
//        int n = 7;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//        int[][] paths = {{1,2,5}, {1,4,1}, {2,3,1},{2,6,7},{4,5,1},{5,6,1},{6,7,1}};
        int max = 0;
        intensity = Integer.MAX_VALUE;
        ArrayList<Node>[] arr = new ArrayList[n+1];

        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<paths.length; i++){
            arr[paths[i][0]].add(new Node(paths[i][1], paths[i][2]));
            arr[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
        }

        for(int i : gates){
            start = i;
            visited[i] = true;

            dfs(i, max, arr);

            max = 0;

            Arrays.fill(visited, false);
        }

        sb.append(result[0]).append(" ").append(result[1]);

        bw.write(sb.toString());
        bw.close();

    }
    public static void dfs(int v, int max, ArrayList<Node>[] arr){
        for(int i=0; i<gates.length; i++){
            if(v == gates[i] && v != start) return;
        }

        for (int summit : summits) {
            if (v == summit) {//봉우리 만나면
                if (max == intensity) {
                    if (result[0] > v) {
                        result[0] = v;
                    }
                } else if (max < intensity) {
                    result[0] = v;
                    result[1] = max;
                } else {
                    result[0] = v;
                    result[1] = intensity;
                }

                return;
            }
        }

        for (Node iter : arr[v]) {
            int e = iter.e;

            if (!visited[e]) {
                visited[e] = true;
                int temp = iter.w;

                if(max < temp){
                    System.out.println(v+"->"+e+" : "+temp);
                    dfs(iter.e, temp, arr);
                }
                else{
                    System.out.println(v+"->"+e+" : "+max);
                    dfs(iter.e, max, arr);
                }
            }
        }
    }
}

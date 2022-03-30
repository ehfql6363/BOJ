package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2644 {
    public static ArrayList<Integer> list;
    public static boolean[] visited;
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

            }
        }
    }
}

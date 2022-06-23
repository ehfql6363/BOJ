package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1068 {

    static int n, delete, count;
    static int[] parent;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n];
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < parent.length; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }
        delete = Integer.parseInt(br.readLine());

        deleteNode(delete);

        count = 0;
        check = new boolean[n];
        countLeaf(root);

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }

    public static void deleteNode(int d) {
        parent[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < n; i++) {
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int root) {
        boolean isLeaf = true;
        check[root] = true;
        if(parent[root] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == root && check[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}

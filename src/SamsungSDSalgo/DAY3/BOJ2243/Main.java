package SamsungSDSalgo.DAY3.BOJ2243;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 인덱스 트리 (카운팅)
 */
public class Main {

    static int n ,S = 1000001;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        /**
         * S = 1;
         * while (S < n) {
         *     S *= 2;
         * }
         *
         * 위 방법으로 안되는 이유
         */
        tree = new int[4 * S];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) { // 사탕 빼기
                int b = Integer.parseInt(st.nextToken()); // b번째 사탕
                sb.append(pop(1, S, 1, b)).append("\n");
            } else if (a == 2) { // 사탕 넣기
                int b = Integer.parseInt(st.nextToken()); // 사탕 맛
                int c = Integer.parseInt(st.nextToken()); // 해당 사탕의 개수
                update(1, S, 1, b, c);

            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int pop(int left, int right, int node, int target) {
        int mid = (left + right) / 2;

        if (left == right){ //리프 노드에 도달하면
            update(1, S, 1, left, -1);
            return left;
        }

        if (tree[node * 2] >= target) {
            return pop(left, mid, node * 2, target);
        }else{
            target -= tree[node * 2];
            return pop(mid + 1, right, node * 2 + 1, target);
        }
    }

    static void update(int left, int right, int node, int target, int diff) {
        // 범위를 벗어난 경우 ( 무의미 )
        if (target < left || target > right) return;
        else{
            tree[node] += diff;

            if (left != right){
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff); //왼쪽 자식
                update(mid + 1, right, node * 2 + 1, target, diff); //오른쪽 자식
            }
        }
    }
}

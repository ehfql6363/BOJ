package SamsungSDSalgo.DAY3.BOJ2243;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n ,S, index;
    static long[] arr = new long[1000001];
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        S = 1;
        while (S < 1000000) {
            S *= 2;
        }

        tree = new long[2 * S];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) { // 사탕 빼기
                index = 0;
                int b = Integer.parseInt(st.nextToken()); // b번째 사탕
                pop(1, S, 1, b);
                sb.append(index).append("\n");
            } else if (a == 2) { // 사탕 넣기
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());

                arr[b] += c;
            }

            init();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {

        // Leaf에 값 반영
        for (int i = 0; i < arr.length - 1; i++) {
            tree[i + S] = arr[i + 1];
        }
        // tree나머지 값 채우기
        for (int i = S-1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        System.out.println(tree[1]);
        System.out.println("tree[2] = " + tree[2]);
        System.out.println("tree[3] = " + tree[3]);

    }

    static void pop(int left, int right, int node, int target) {
        int mid = (left + right) / 2;
        if (left == right){ //리프 노드에 도달하면
            tree[node]--;
            index = node - S + 1;
            return;
        }
        if (tree[node * 2] <= target) {
//            System.out.println("Left");
            pop(left, mid, node * 2, target);
        }else{
//            System.out.println("Right");
            target -= tree[node * 2];
            pop(mid + 1, right, node * 2 + 1, target);
        }
    }

}

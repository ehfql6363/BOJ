package SamsungSDSalgo.DAY3.BOJ2042;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2042 {
    static int N, M, K, S;
    static long[] tree;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }

        tree = new long[S * 2];
        initBU();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //a == 1이면 b번째를 c로 변경
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                updateBU(b,c);
            }
            //a == 2이면 b부터 c까지의 합
            if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                sb.append(queryBU(b, c)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[i + S] = nums[i];
        }
        // tree나머지 값 채우기
        for (int i = S-1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관 없음 -> 결과에 영향이 없는 값 return
        if (queryLeft > right || queryRight < left) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return queryLeft와 queryRight안에 left, right가 있는 경우
        else if (left >= queryLeft && queryRight >= right) {
            return tree[node];
        }
        // 판단 불가, 자식에게 위임 -> 자식에서 올라온 값을 합
        else{
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        //연관 없음
        if (target < left || right < target) {
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff전달
        else{
            tree[node] += diff;

            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2, target, diff);
            }
        }
    }

    static long queryBU(int queryLeft, int queryRight) {
        // Leaf에서 left, right설정
        int left = S + queryLeft - 1;
        int right = S + queryRight -1;
        long sum = 0;
        while(left <= right){
            // 좌측 노드가 홀수면, 현재 노드 값 사용하고 한칸 옆으로 이동
            if (left % 2 == 1) sum += tree[left++];
            // 우측 노드가 짝수면, 현재 노드 값 사용하고 한칸 옆으로 이동
            if (right % 2 == 0) sum += tree[right--];
            // 좌측, 우측, 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        //Leaf에서 target 찾기
        int node = S + target - 1;

        //value 반영
        tree[node] = value;
        //Root에 도달할 때까지 부모에 값 반영
        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}

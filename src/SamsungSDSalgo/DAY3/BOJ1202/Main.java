package SamsungSDSalgo.DAY3.BOJ1202;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long max = 0;

        Jewel[] jewels = new Jewel[N];
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.w == o2.w) {
                return o2.val - o1.val;
            }
            return o1.w - o2.w;
        });

        for (int i = 0; i < bag.length; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j=0; i < K; i++) {
            while (j < N && jewels[j].w <= bag[i]) {
                pq.offer(jewels[j++].val); // 중복 저장을 방지하기 위해 j를 수동 증가
            }
            if (!pq.isEmpty()) max += pq.poll();
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Jewel{
    int w;
    int val;

    public Jewel(int w, int val) {
        this.w = w;
        this.val = val;
    }
}
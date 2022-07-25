package SamsungSDSalgo.DAY6.BOJ2252;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상정렬
 */

public class Main {

    static int[] inDegree;
    static ArrayList<Integer>[] out;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        out = new ArrayList[N + 1];
        for (int i = 0; i < out.length; i++) {
            out[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int follow = Integer.parseInt(st.nextToken());

            inDegree[follow]++;
            out[pre].add(follow);
        }

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        sort();

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void sort() {
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int i : out[pre]) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            sb.append(pre).append(" ");
        }
    }
}

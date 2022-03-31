package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2812 {
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(str.charAt(0) - '0');

        greedy(stack, str);

        while(stack.size() > k){
            sb.append(stack.poll());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void greedy(Deque<Integer> stack, String str) {
        for (int i = 1; i < str.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < (str.charAt(i) - '0')) {
                stack.removeLast();
                k--;
            }
            stack.add(str.charAt(i) - '0');
        }
    }
}
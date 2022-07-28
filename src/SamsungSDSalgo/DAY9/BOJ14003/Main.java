package SamsungSDSalgo.DAY9.BOJ14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] lis;
    static int[] idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        lis = new int[N];
        idx = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        lis[len] = arr[0];
        idx[0] = len;

        for (int i = 1; i < arr.length; i++) {
            if (lis[len] < arr[i]){
                len++;
                lis[len] = arr[i];
                idx[i] = len;
            }else{
                int index = binarySearch(0, len, arr[i]);
                lis[index] = arr[i];
                idx[i] = index;
            }
        }

        sb.append(len+1).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0 ; i--) {
            if (idx[i] == len) {
                len--;
                stack.add(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int binarySearch(int low, int high, int target) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (lis[mid] < target) low = mid + 1;
            else high = mid;
        }
        return high;
    }
}

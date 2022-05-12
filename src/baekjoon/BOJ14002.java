package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {
    public static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        lis = new int[n];
        int[] idxArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len=0;
        lis[len] = arr[0];
        idxArr[0] = len;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > lis[len]){
                len++;
                lis[len] = arr[i];
                idxArr[i] = len;
            }
            else{
                int idx = getIndex(0, len, arr[i]);
                lis[idx] = arr[i];
                idxArr[i] = idx;
            }
        }
        sb.append(len+1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int temp = len;
        for(int i = n-1; i>=0; i--){
            if(idxArr[i] == temp){
                stack.add(arr[i]);
                temp--;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    public static int getIndex(int left, int right, int val){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(lis[mid] < val) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}

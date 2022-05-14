package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class TargetNumber_DFS_BFS {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(numbers, 0, 0, target);

        bw.write(String.valueOf(answer));
        bw.close();
    }
    public static void dfs(int[] arr, int depth, int sum, int target){
        if(depth == arr.length){
            if(sum == target) answer++;
        }
        else{
            dfs(arr, depth+1, sum + arr[depth], target);
            dfs(arr, depth+1, sum - arr[depth], target);
        }
    }
}

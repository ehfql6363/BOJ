package baekjoon;

import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        Deque<Integer> answer = new LinkedList<>();
        answer.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(arr[i] == answer.peekLast()) continue;
            answer.add(arr[i]);
        }

        while(!answer.isEmpty()){
            System.out.println(answer.pollFirst());
        }

        /*
        bw.write(answer);
        bw.flush();
        */
        bw.close();
        br.close();
    }
}

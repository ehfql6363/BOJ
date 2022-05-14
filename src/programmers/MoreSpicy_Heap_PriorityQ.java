package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MoreSpicy_Heap_PriorityQ {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] scoville = {1,1,6,6};
        int K = 7;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }

        int answer = 0;

        while(pq.peek() < K){
            int min1 = pq.poll();

            if(pq.isEmpty()){
                if(min1 < K) {
                    answer = -1;
                    break;
                }
            }

            int min2 = pq.poll();
            int next = min1 + min2*2;
            pq.add(next);

            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}

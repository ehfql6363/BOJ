package SamsungSDSalgo.DAY3.BOJ1927;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
                continue;
            }
            pq.add(num);
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

class MinHeap{
    List<Integer> list;

    public MinHeap(){
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        // 1. leaf 마지막 삽입
        list.add(val);
        // 2. 부모와 비교 후 조건에 맞지 않으면 SWAP
        // 3. 조건이 만족되거나 root까지 반복
        int current = list.size() - 1;
        int parent = current / 2;
        while (true) {
            if (parent == 0 || list.get(parent) <= list.get(current)) break;

            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete(){
        if (list.size() == 1) return 0;

        // 1. root에 leaf 마지막 데이터 가져옴.
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // 2. 자식과 비교 후 조건이 맞지 않으면 SWAP
        // 3. 조건이 만족되거나 leaf까지 반복
        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;

            // 왼쪽 자식 먼저 확인
            if (leftPos >= list.size()) break;

            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 자식 확인
            if (rightPos < list.size() && minValue > list.get(rightPos)) {
                minValue = list.get(rightPos);
                minPos = rightPos;
            }

            // SWAP
            if (list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos, temp);
                currentPos = minPos;
            }
        }

        return top;
    }
}

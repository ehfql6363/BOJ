package SamsungSDSalgo.DAY2.BOJ2143;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> listA = new ArrayList<>();
    static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }

        for (int i = 0; i < B.length; i++) {
            int sum = 0;
            for (int j = i; j < B.length; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        bw.write(String.valueOf(sol(T)));
        bw.close();
        br.close();
    }

    static long sol(int T) {
        long count = 0;
        int pointerA = 0;
        int pointerB = listB.size() - 1;

        while (pointerA < listA.size() && pointerB >= 0) {
            long sum = listA.get(pointerA) + listB.get(pointerB);

            if (sum == T) {
                int a = listA.get(pointerA);
                int b = listB.get(pointerB);
                long countA = 0;
                long countB = 0;

                for (; pointerA < listA.size(); pointerA++) {
                    if(listA.get(pointerA) == a){
                        countA++;
                    }else break;
                }
                for (; pointerB >= 0; pointerB--) {
                    if(listB.get(pointerB) == b){
                        countB++;
                    }else break;
                }
                count += countA * countB;
            }
            else if (sum > T) pointerB--;
            else pointerA++;
        }

        return count;
    }
}

package programmers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answers = {1,2,3,4,5};
        //int answers = {1,3,2,4,2};

        int[] no1 = {1,2,3,4,5};
        int[] no2 = {2,1,2,3,2,4,2,5};
        int[] no3 = {3,3,1,1,2,2,4,4,5,5};

        int cnt[] = new int[4];

        int person = 1;
        while(person < 4){
            int count = 0;
            if(person == 1){
                for(int i =0; i<no1.length;i++){
                    if(no1[i] == answers[i]) count++;
                }
                cnt[person] = count;
            }
            if(person == 2){
                for(int i =0; i<no2.length;i++){
                    if(no2[i] == answers[i]) count++;
                }
                cnt[person] = count;
            }
            if(person == 3){
                for(int i =0; i<no3.length;i++){
                    if(no3[i] == answers[i]) count++;
                }
                cnt[person] = count;
            }

            person++;
        }

        int max = Math.max(cnt[1], Math.max(cnt[2],cnt[3]));
        ArrayList<Integer> list = new ArrayList<>();

        if(max == cnt[1]) list.add(1);
        if(max == cnt[2]) list.add(2);
        if(max == cnt[3]) list.add(3);

        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

    }
}

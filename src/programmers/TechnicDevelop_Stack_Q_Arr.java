package programmers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class TechnicDevelop_Stack_Q_Arr {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] progresses = {93,30,55};
        int[] speeds = {1, 30, 5};

        int[] arr = new int[100];
        int day = 0;

        for(int i=0; i<progresses.length; i++){
            while (progresses[i] + speeds[i]*day < 100) day++;
            arr[day]++;
        }

        int cnt = 0;
        for(int i : arr){
            if(i != 0) cnt++;
        }

        int[] answer = new int[cnt];

        cnt = 0;

        for(int i: arr){
            if(i != 0) {
                answer[cnt] = i;
                cnt++;
            }
        }


    }
}

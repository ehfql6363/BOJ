package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Budget {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = {2,2,3,3};
        int budget = 10;
        int answer = 0;

        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            budget -= d[i];
            if(budget < 0) break;
            answer++;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

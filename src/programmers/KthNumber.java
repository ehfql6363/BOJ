package programmers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.Collections;

public class KthNumber {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1},{1,7,3}};

        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> list = new ArrayList<>();

            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                list.add(array[j]);
            }

            Collections.sort(list);

            answer[i] =  list.get(commands[i][2]-1);
        }
    }
}

package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class P3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] beverage = {{1,2,2},{3,1,1}};
        int p = 3;
        int answer=0;

        Arrays.sort(beverage, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                double rate1 = (double)o1[2]/(double) o1[1];
                double rate2 = (double)o2[2]/(double) o2[1];
                if(rate1 == rate2) return o1[1] - o2[1];
                else return Double.compare(rate2, rate1);
            }
        });

        for(int i=0; i<beverage.length; i++){
            for(int j =0; j<beverage[i].length; j++){
                System.out.print(beverage[i][j]+" ");
            }
            System.out.println();
        }

        int idx = 0;
        while(p > 0){
            beverage[idx][0]--;
            p -= beverage[idx][1];
            answer += beverage[idx][2];

            int min = Integer.MAX_VALUE;
            for(int i=0; i<beverage.length; i++){
                if(beverage[i][0] != 0){
                    min = Math.min(min, beverage[i][1]);
                }
            }

            if(min >= p){
                double max = Integer.MIN_VALUE;
                int maxIdx = 0;
                for(int i=0; i<beverage.length; i++){
                    if(beverage[i][0]!=0){
                        double rate = (double)beverage[i][2]/(double)beverage[i][1];
                        max = Math.max(max, rate);
                        maxIdx = i;
                    }
                }
                answer += beverage[maxIdx][2];
                break;
            }

            if(beverage[idx][0] == 0) idx++;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}

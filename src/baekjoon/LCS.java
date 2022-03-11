package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;

public class LCS{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String[] strArr1 = new String[str1.length()+1];
        String[] strArr2 = new String[str2.length()+1];
        int[][] lenArr = new int[str1.length()+1][str2.length()+1];

        for (int i=1; i< strArr1.length; i++){
            strArr1[i] = String.valueOf(str1.charAt(i-1));

        }
        for(int i=1; i< strArr2.length; i++) {
            strArr2[i] = String.valueOf(str2.charAt(i-1));
        }

        for(int i=1; i<strArr1.length; i++){
            for(int j=1; j<strArr2.length; j++){
                if(Objects.equals(strArr1[i], strArr2[j])){
                    lenArr[i][j] = lenArr[i-1][j-1] + 1;
                }else{
                    lenArr[i][j] = Math.max(lenArr[i-1][j], lenArr[i][j-1]);
                }
            }
        }

        System.out.println(lenArr[strArr1.length-1][strArr2.length-1]);
    }
}
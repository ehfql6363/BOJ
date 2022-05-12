package programmers;

import java.io.*;

public class kakao1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        int[] ans = new int[4]; //0: R/T, 1:C/F, 2:J/M, 3:A/N

        for(int i=0; i<survey.length; i++){
            int score = choices[i] - 4;

            if(survey[i].charAt(0) == 'R' || survey[i].charAt(0) == 'T'){
                int idx = 0;
                if (score>=0){
                    char ch = survey[i].charAt(0);
                    if(ch == 'R') ans[idx] += score;
                    else ans[idx] -= score;
                }else{
                    char ch = survey[i].charAt(1);
                    if(ch == 'T') ans[idx] -= score;
                    else ans[idx] += score;
                }
            }
            else if (survey[i].charAt(0) == 'C' || survey[i].charAt(0) == 'F'){
                int idx = 1;
                if (score>=0){
                    char ch = survey[i].charAt(0);
                    if(ch == 'C') ans[idx] += score;
                    else ans[idx] -= score;
                }else{
                    char ch = survey[i].charAt(1);
                    if(ch == 'F') ans[idx] -= score;
                    else ans[idx] += score;
                }
            }else if(survey[i].charAt(0) == 'J' || survey[i].charAt(0) == 'M'){
                int idx = 2;
                if (score>=0){
                    char ch = survey[i].charAt(0);
                    if(ch == 'J') ans[idx] += score;
                    else ans[idx] -= score;
                }else{
                    char ch = survey[i].charAt(1);
                    if(ch == 'M') ans[idx] -= score;
                    else ans[idx] += score;
                }
            }else if(survey[i].charAt(0) == 'A' || survey[i].charAt(0) == 'N'){
                int idx = 3;
                if (score>=0){
                    char ch = survey[i].charAt(0);
                    if(ch == 'A') ans[idx] += score;
                    else ans[idx] -= score;
                }else{
                    char ch = survey[i].charAt(1);
                    if(ch == 'N') ans[idx] -= score;
                    else ans[idx] += score;
                }
            }
        }

        for(int i=0; i<ans.length; i++){
            switch (i){
                case 0: if(ans[i] >= 0) sb.append('R');
                        else sb.append('T');
                        break;
                case 1: if(ans[i] >= 0) sb.append('C');
                        else sb.append('F');
                        break;
                case 2: if(ans[i] >= 0) sb.append('J');
                        else sb.append('M');
                        break;
                case 3: if(ans[i] >= 0) sb.append('A');
                        else sb.append('N');
                        break;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}

package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] birth =  {"1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"};
        int answer = 0;

        for(int i=0; i<birth.length; i++){
            if(isDate(birth[i])) {
                System.out.println(i+1);
                answer++;
            }
        }
        if(answer == -1) answer = 0;

        bw.write(String.valueOf(answer));
        bw.close();
    }
    public static boolean isDate(String str){
        String[] date = str.split("-");
        if(date.length != 3) return false;

        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);

        if(y<1900 || y > 2021) return false;

        if(date[1].length() != 2) return false;

        if(m == 1 || m == 3 || m  == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            if(d < 1 || d > 31) return false;
        }else if(m == 4 || m == 6 || m == 9 || m== 11){
            if(d < 1 || d > 30) return false;
        }else if(m == 2){
            if(y%4==0 && y%100!=0 || y%400==0){
                if(d < 1 || d > 29) return false;
            }else{
                if(d < 1 || d > 28) return false;
            }
        }else if(m < 1 || m > 12) return false;

        return true;
    }
}

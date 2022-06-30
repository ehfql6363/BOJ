package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String p = "000";
        String s = "000";
        int answer = 0;

        Queue<Character> q = new LinkedList<>();

        for(Character ch : s.toCharArray()){
            q.add(ch);
        }
        int idx = 0;
        while(!q.isEmpty()){
            char c = q.poll();
            if(c == p.charAt(idx)){
                idx++;
                if(idx == p.length()) idx = 0;
            }
            else{
                answer++;
            }
        }
        if(idx != 0) answer += idx;
        if(answer == s.length()) answer = -1;

        bw.write(String.valueOf(answer));
        bw.close();
    }
}

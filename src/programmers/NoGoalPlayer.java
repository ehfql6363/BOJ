package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NoGoalPlayer {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String player : completion){
            map.put(player, map.get(player) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

//        while(iter.hasNext()){
//            Map.Entry<String, Integer> entry = iter.next();
//            if(entry.getValue() != 0) {
//                answer = entry.getKey();
//                break;
//            }
//        }

        bw.write(answer);
        bw.close();
    }
}

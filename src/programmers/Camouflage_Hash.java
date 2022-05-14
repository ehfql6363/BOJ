package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class Camouflage_Hash {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        HashMap<String, Integer> map = new HashMap<>();
        for(String[] arr : clothes){
            String type = arr[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        Iterator<Integer> iter = map.values().iterator();
        answer = 1;
        while(iter.hasNext()){
            answer *= iter.next() + 1;
        }

        bw.write(String.valueOf(answer-1));
        bw.close();
    }
}

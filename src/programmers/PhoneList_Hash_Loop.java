package programmers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneList_Hash_Loop {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean answer = true;

        String[] phone_book = {"119", "97674223", "1195524421"};
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }

//        HashMap<String, Integer> hmap = new HashMap<>();
//
//        for(int i=0; i<phone_book.length; i++){
//            hmap.put(phone_book[i], i);
//        }
//
//        for(int i=0; i<phone_book.length; i++){
//            for(int j=0; j<phone_book[i].length(); j++){
//                if(hmap.containsKey(phone_book[i].substring(0, j))) answer = false;
//            }
//        }

        System.out.println(answer);
    }
}

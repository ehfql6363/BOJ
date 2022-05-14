package GDSC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

public class P1 {
    public static void main(String[] args) {
        //문제 1
        String str = "this is a test sentence";
        String[] ans1 = str.split(" ");
        System.out.println(ans1[ans1.length-1]);

        //문제 2
        Scanner sc2 = new Scanner(System.in);
        String st = sc2.next();
        byte ans2 = st.getBytes(StandardCharsets.UTF_8)[0];
        System.out.println(ans2);

        //문제 3
        Stack<Integer> stack = new Stack<>();
        Scanner sc3 = new Scanner(System.in);
        String n3 = String.valueOf(sc3.nextInt());
        String[] ans3 = new String[n3.length()];

        for(int i=0; i<n3.length(); i++){

        }

        //문제 4

        //문제 5
        /*
        def solution(s):

            num_dic = {'zero': '0', 'one': '1', 'two': '2', 'three': '3',
               'four': '4', 'five': '5', 'six': '6', 'seven': '7',
               'eight': '8', 'nine': '9'}

            for key, val in num_dic.items():
                s = s.replace(key, val)

            return int(s)

         */
    }
}

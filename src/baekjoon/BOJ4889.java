package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int test = 1;


        while(true){

            int ans = 0;
            String str = sc.next();
            char[] brackets = str.toCharArray();

            if(brackets[0] == '-') break;

            Stack<Character> stack = new Stack<>();

            for (char bracket : brackets) {
                if (bracket == '{') {
                    stack.add(bracket);
                } else {
                    if (stack.isEmpty()) {
                        ans++;
                        stack.add('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(test).append(". ").append(ans + stack.size()/2).append("\n");
            test++;
        }
        System.out.println(sb);
    }
}

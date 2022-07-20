package baekjoon;

import java.util.Scanner;

public class BOJ16916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        if(str1.contains(str2)) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

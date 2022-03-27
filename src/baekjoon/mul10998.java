package baekjoon;

import java.util.Scanner;

public class mul10998{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x>0 && y<10){
            System.out.print(x*y);
        }
    }
}
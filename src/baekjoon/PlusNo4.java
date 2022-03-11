package baekjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PlusNo4 {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}

package baekjoon;

import java.util.Scanner;

public class div1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x>0 && y<10){
            double dx = (double)(x);
            double dy = (double)(y);
            System.out.print(dx/dy);
        }
	}

}

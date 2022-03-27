package baekjoon;

import java.util.Scanner;

public class arithmeticOperation10869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x>=1 && y>=1 && x<=10000 && y<10000) {
			System.out.print(x+y+"\n");
			System.out.print(x-y+"\n");
			System.out.print(x*y+"\n");
			System.out.print(x/y+"\n");
			System.out.print(x%y);
		}
	}

}
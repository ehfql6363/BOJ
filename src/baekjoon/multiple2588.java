package baekjoon;

import java.util.Scanner;

public class multiple2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int mul1 = x * (y % 10);
		int mul2 = x * ((y / 10) % 10);
		int mul3 = x * ((y / 100) % 10);
		int total = x * y;
		
		System.out.println(mul1);
		System.out.println(mul2);
		System.out.println(mul3);
		System.out.print(total);
	}

}

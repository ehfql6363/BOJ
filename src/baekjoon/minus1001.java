package baekjoon;

import java.util.Scanner;

public class minus1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x>0 && y<10) {
			System.out.print(x-y);
		}
	}

}
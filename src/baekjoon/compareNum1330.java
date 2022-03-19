package baekjoon;

import java.util.Scanner;

public class compareNum1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x>y) {System.out.println(">");}
		else if(x<y) {System.out.println("<");}
		else {System.out.println("==");}
	}

}

package baekjoon;

import java.util.Scanner;

public class grade9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		if(90<=grade && grade<=100) {
			System.out.println("A");
		}
		else if(80<=grade && grade<=89) {
			System.out.println("B");
		}
		else if(70<=grade && grade<=79) {
			System.out.println("C");
		}
		else if(60<=grade && grade<=69) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
	}

}

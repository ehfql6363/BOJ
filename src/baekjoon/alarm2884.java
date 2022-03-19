package baekjoon;

import java.util.Scanner;

public class alarm2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int minusM = m - 45;
		
		if(0<=h && h<24 && 0<=m && m<=59) {
			if(minusM<0) {
				if(h==0) {
					h = 23;
					m = (m + 60) - 45;
					System.out.print(h+" "+m);
				}
				else {
					h -= 1;
					m = (m + 60) - 45;
					System.out.print(h+" "+m);
				}
			}
			else {
				System.out.print(h+" "+minusM);
			}
		}
	}
}

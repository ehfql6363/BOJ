package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleGame4370 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean flagB = true;
		boolean flagD = false;
		
		while(true) {
			if(flagB) {
				if(n>=2 && n<=9) {
					System.out.println("Baekjoon wins.");
					break;
				}else {
					if(n % 2 ==0) n = n/2;
					else if(n % 3 == 0) n = n/3;
					else if(n % 5 == 0) n = n/5;
					else if(n % 7 == 0) n = n/7;
				}
				flagB = false;
				flagD = true;
			}
			if(flagD) {
				if(n>=2 && n<=9) {
					System.out.println("Donghyuk wins.");
					break;
				}else {
					if(n % 2 ==0) n = n/2;
					else if(n % 3 == 0) n = n/3;
					else if(n % 5 == 0) n = n/5;
					else if(n % 7 == 0) n = n/7;
				}
				flagB = true;
				flagD = false;
			}
		}
	}

}

package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class easy1292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<Integer>();
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		int sum = 0;
		
		if(1<=start && start<=end && end<=1000) {
			for(int i=1; i<=end; i++) {
				for(int j=(i*(i-1))/2; j<(i*(i-1))/2+i; j++) {
					arr.add(i);
				}
			}
			for(int i=start-1; i<end; i++) {
				sum += arr.get(i);
			}
			System.out.print(sum);
			
		}
	}
}
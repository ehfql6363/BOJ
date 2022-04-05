package baekjoon;

import java.io.*;
import java.util.Scanner;

public class BOJ4370 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int ans = sc.nextInt();
			int p = 1;

			while(true){
				p *= 9;
				if(p >= ans){
					System.out.println("Baekjoon wins.");
					break;
				}
				p *= 2;
				if(p >= ans){
					System.out.println("Donghyuk wins.");
					break;
				}
			}
		}
	}

}

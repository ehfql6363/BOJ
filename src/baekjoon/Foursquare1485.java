package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Foursquare1485 {
	public static int N;
	public static double[] len;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int[] x = new int[4];
		int[] y = new int[4];
		len = new double[6];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 4; j++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				x[j] = Integer.parseInt(str.nextToken());
				y[j] = Integer.parseInt(str.nextToken());
			}
			distance(x, y);
			sort();
			if(isSquare(len)) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void distance(int[] x, int[] y) {
		int index = 0;
		for(int i=0; i<3; i++) {
			for(int j=i+1; j<4; j++) {
				len[index] = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
				index++;
			}
		}
	}
	public static void sort() {
		for(int i = 0; i < len.length-1; i++) {
			for(int j = i+1; j < len.length; j++) {
				if(len[i] > len[j]) {
					swap(i, j);
				}
			}
		}
	}
	
	public static void swap(int a, int b) {
		double temp = len[a];
		len[a] = len[b];
		len[b] = temp;
	}
	public static boolean isSquare(double[] len) {
		boolean case1 = len[0] == len[1];
		boolean case2 = len[1] == len[2];
		boolean case3 = len[2] == len[3];
		boolean case4 = len[4] == len[5];
		
		if(case1 && case2 && case3 && case4) return true;
		else return false;
	}
}
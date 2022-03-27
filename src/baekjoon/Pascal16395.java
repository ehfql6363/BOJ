package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pascal16395 {
	public static int[][] pascal;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		pascal = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0 || j == i)
					pascal[i][j] = 1;
				else 
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		System.out.print(pascal[n-1][k-1]);
	}
}
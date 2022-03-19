package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCard10815 {
	public static boolean[] check = new boolean[20000001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			check[Integer.parseInt(st.nextToken()) + 10000000] = true;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			if(check[Integer.parseInt(st.nextToken()) + 10000000]) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
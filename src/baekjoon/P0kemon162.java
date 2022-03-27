package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P0kemon162 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String, String> handBook = new HashMap<String, String>();
		
		int n = Integer.parseInt(st.nextToken());
		int quest = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<n+1; i++) {
			String str = br.readLine();
			handBook.put(Integer.toString(i), str);
			handBook.put(str, Integer.toString(i));
		}
		
		for(int i=0; i<quest; i++) {
			String str = br.readLine();
			sb.append(handBook.get(str)).append("\n");
		}
		
		System.out.println(sb);
	}
}

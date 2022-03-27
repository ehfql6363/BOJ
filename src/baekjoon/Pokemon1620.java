package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pokemon1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, String> handBook = new HashMap<Integer, String>();
		
		int n = Integer.parseInt(st.nextToken());
		int quest = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<n+1; i++) {
			handBook.put(i, br.readLine());
		}
		
		for(int i=0; i<quest; i++) {
			String str = br.readLine();
			if(getKey(handBook, str) != null) 
				sb.append(getKey(handBook, str)).append("\n");
			else sb.append(handBook.get(Integer.parseInt(str))).append("\n");
		}
		
		System.out.println(sb);
	}
	public static <K, V> K getKey(HashMap<K, V> map, V value){
		for(K key : map.keySet()) {
			if(value.equals(map.get(key))) return key;
		}
		return null;
	}

}

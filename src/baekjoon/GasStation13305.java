package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation13305 {
	public static long[] edge;
	public static long[] node;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long oilPrice = 0;
		int size = Integer.parseInt(br.readLine());
		edge = new long[size-1];
		node = new long[size];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<edge.length; i++) {
			edge[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<edge.length; i++) {
			if(node[i] < node[i+1]) {
				node[i+1] = node[i];
			}
		}
		for(int i=0; i<edge.length; i++) {
			oilPrice += node[i] * edge[i];
		}
		System.out.println(oilPrice);
	}

}

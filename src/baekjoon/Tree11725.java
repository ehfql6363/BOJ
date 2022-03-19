package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree11725 {
	public static ArrayList<Integer> list[];
	public static int[] parents;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		check = new boolean[n+1];
		parents = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		check[1] = true;
		q.add(1);
		
		dfs(q);
		
		for(int i=2; i<parents.length; i++) {
			System.out.println(parents[i]);
		}
	}
	
	public static void dfs(Queue<Integer> q) {
		while (!q.isEmpty()) {
			int node = q.poll();

			for (int i : list[node]) {
				if (!check[i]) {
					q.add(i);
					parents[i] = node;
					check[i] = true;
				}

			}

		}
	}
}

package baekjoon;

import java.util.Scanner;

public class Virus2606 {
	public static int[][] graph;
	public static boolean[] visited;
	public static int COUNT = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int node = sc.nextInt();
		int edge = sc.nextInt();
		
		visited = new boolean[node+1];
		graph = new int[node+1][node+1];
		
		for(int i=0; i<edge; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			graph[n1][n2] = graph[n2][n1] = 1;
		}
		dfs(1);
		System.out.print(COUNT-1);
	}
	
	public static void dfs(int node) {
		if(visited[node]) return ;
		
		visited[node] = true;
		COUNT++;
		
		for(int i=0; i<graph[node-1].length; i++) {
			if(graph[node][i] == 1 && !visited[i]) dfs(i);
		}
	}
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindCity18352 {
	public static ArrayList<Integer> list[];
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static int[] depth;
	public static int count;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int minDist = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		depth = new int[node+1];
		visited = new boolean[node+1];
		
		list = new ArrayList[node+1];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<edge; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			list[a].add(b);
		}
		
		q.add(start);
		bfs();
		
		for(int i=0; i<depth.length; i++) {
			if(depth[i] == minDist) sb.append(i).append("\n");
		}
		if(sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i : list[n]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
					depth[i] = depth[n] + 1;
				}
			}
		}
		
	}

}

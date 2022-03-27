package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MinDistance1753 {
	public static ArrayList<int[]> list[];
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static int[] distance;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		distance = new int[node+1];
		visited = new boolean[node+1];
		list = new ArrayList[node+1];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int[][] arr = new int[edge][2];
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[i][0] = e;
			arr[i][1] = w;
			list[s].add(arr[i]);
		}
		
		visited[start] = true;
		q.add(start);
		search();
		distance[start] = 0;
		
		for(int i = 1; i<distance.length; i++) {
			if(i != start && distance[i] == 0) {
				sb.append("INF").append("\n");
			}else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void search() {
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i = 0; i<list[n].size(); i++) {
				if(!visited[list[n].get(i)[0]]) {
					distance[list[n].get(i)[0]] = distance[n] + list[n].get(i)[1];
					visited[list[n].get(i)[0]] = true;
				}
				else {
					int wei = distance[n] + list[n].get(i)[1];
					distance[list[n].get(i)[0]] = Math.min(wei, distance[list[n].get(i)[0]]);
				}	
				q.add(list[n].get(i)[0]);
				
			}
		}
	}

}
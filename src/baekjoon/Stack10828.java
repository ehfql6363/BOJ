package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack10828 {
	public static int[] stack;
	public static int TOP = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		stack = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "top":
				sb.append(top()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	public static void push(int n) {
		stack[TOP] = n;
		TOP++;
	}
	public static int pop() {
		if(TOP == 0) return -1;
		TOP--;
		return stack[TOP];
	}
	public static int size() {
		return TOP;
	}
	public static int top() {
		if(TOP==0) return -1;
		else return stack[TOP-1];
	}
	public static int empty() {
		return TOP==0 ? 1 : 0;
	}

}

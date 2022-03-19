package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue18258 {
	public static int[] queue;
	public static int HEAD = 0;
	public static int TAIL = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		queue = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
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
		queue[TAIL] = n;
		TAIL++;
	}

	public static int pop() {
		if (HEAD == TAIL)
			return -1;
		else {
			int num = queue[HEAD];
			HEAD++;
			return num;
		}
			
	}

	public static int back() {
		if(TAIL == HEAD) return -1;
		return queue[TAIL-1];
	}

	public static int size() {
		return TAIL - HEAD;
	}

	public static int front() {
		if(TAIL == HEAD) return -1;
		return queue[HEAD];
	}

	public static int empty() {
		return TAIL - HEAD == 0 ? 1 : 0;
	}
}

package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQ11286 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int n1 = Math.abs(o1);
				int n2 = Math.abs(o2);

				if (n1 == n2) {
					return o1 - o2;
				} else {
					if (n1 < n2) return -1;
					else if (n1 > n2) return 1;
					return 0;
				}

			}
		});

		priority(q);
		
	}
	public static void priority(PriorityQueue<Integer> q) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			if(a == 0) {
				if(q.isEmpty()) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}else {
				q.add(a);
			}
		}
		System.out.println(sb);
	}
}
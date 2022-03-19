package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Paper1780 {
	public static int[][] paper;
	public static int minus = 0;
	public static int zero = 0;
	public static int plus = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		paper = new int[size][size];
		
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count(0, 0, size);
		
		sb.append(minus+"\n").append(zero+"\n").append(plus+"\n");
		System.out.println(sb);
	}
	public static void count(int rows, int cols, int size) {
		if(check(rows, cols, size)) {
			if(paper[rows][cols] == -1)
				minus++;
			if(paper[rows][cols] == 0)
				zero++;
			if(paper[rows][cols] == 1)
				plus++;
		}else {
			int newSize = size / 3;
			
			count(rows, cols, newSize); //1
			count(rows, cols+newSize, newSize); //2
			count(rows, cols+newSize*2, newSize); //3
			count(rows+newSize, cols, newSize); //4
			count(rows+newSize, cols+newSize, newSize); //5
			count(rows+newSize, cols+newSize*2, newSize); //6
			count(rows+newSize*2, cols, newSize); //7
			count(rows+newSize*2, cols+newSize, newSize); //8
			count(rows+newSize*2, cols+newSize*2, newSize); //9
		}
	}
	public static boolean check(int rows, int cols, int size) {
		int a = paper[rows][cols];
		for(int i=rows; i<rows+size; i++) {
			for(int j=cols; j<cols+size; j++) {
				if(paper[i][j] != a) return false;
			}
		}
		return true;
	}
	
}

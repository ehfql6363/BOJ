package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalRobot22342 {
	public static int ROWS;
	public static int COLS;
	public static int MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ROWS = Integer.parseInt(st.nextToken());
		COLS = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[ROWS][COLS]; //로봇 가중치 배열
		int[][] robot = new int[ROWS][COLS]; //로봇의 출력 값 배열
		
		fillArr(arr, br); //로봇 가중치 채우기 - line 28
		dp(robot, arr);
		
//		for(int i=0; i<ROWS; i++) {
//			for(int j=0; j<COLS; j++) {
//				System.out.print(robot[i][j]+" ");
//			}System.out.println();
//		}
		
		System.out.println(MAX);
		br.close();
	}
	public static void fillArr(int[][] arr, BufferedReader br) throws IOException {
		for(int i=0; i<ROWS; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
	}
	public static void dp(int[][] robot, int[][] arr) {
		for(int j=0; j<COLS; j++) {
			for(int i=0; i<ROWS; i++) {
				int count = 0;
				if(j>0) {
					count = robot[i][j-1];
					if(i>0) count = Math.max(robot[i-1][j-1], count);
					if(i<ROWS-1) count = Math.max(count, robot[i+1][j-1]);
					robot[i][j] = count + arr[i][j];
				}
				else {
					robot[i][j] = arr[i][j];
				}
				MAX = Math.max(MAX, count);
			}
		}
	}
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArrayCom {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//solArr(n, m, st, sb, br);
		solQ(n, m, st, sb, br);
		
	}
	//solArr : start
	public static void solArr(int n, int m, StringTokenizer st, StringBuilder sb, BufferedReader br) throws IOException {
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		
		fillArr(arr1, st, br);
		fillArr(arr2, st, br);
		
		int[] comArr = new int[arr1.length + arr2.length];
		combine(arr1, arr2, comArr);
		sort(comArr);
		printArr(comArr, sb);
	}
	public static void fillArr(int[] arr, StringTokenizer st, BufferedReader br) throws IOException {
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	public static void combine(int[] arr1, int[] arr2, int[] comArr) {
		for(int i=0; i<arr1.length; i++) {
			comArr[i] = arr1[i];
		}
		for(int i=0; i<arr2.length; i++) {
			comArr[arr1.length + i] = arr2[i];
		}
	}
	public static void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) swap(arr, i, j);
			}
		}
	}
	public static void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void printArr(int[] arr, StringBuilder sb) {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	} //solArr : end
	
	//solQ : start
	public static void solQ(int n, int m, StringTokenizer st, StringBuilder sb, BufferedReader br) throws IOException {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		addQ(q, n, st, br);
		addQ(q, m, st, br);
		printQ(q, sb);
	}
	public static void addQ(PriorityQueue<Integer> q, int n, StringTokenizer st, BufferedReader br) throws IOException {
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
	}
	public static void printQ(PriorityQueue<Integer> q, StringBuilder sb) {
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		System.out.println(sb);
	}// solQ : end
}

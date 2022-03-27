package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SafeSpace2468 {
	public static int COUNT = 1;
	public static int N; //2���� �迭(����)�� ũ��
	public static boolean visited[][]; //�湮�ߴ��� Ȯ��
	public static int[] rows = {-1, 0, 1, 0}; //4�� Ž�� x��ǥ
	public static int[] cols = {0, -1, 0, 1}; //4�� Ž�� y��ǥ

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //������ ũ�� �Է�
		int[][] space = new int[N][N]; //������ ũ�� �ʱ�ȭ
		visited = new boolean[N][N]; //�湮 Ȯ�ο� �迭 �ʱ�ȭ
		
		fillArr(space, br); //�ǹ��� ũ�� �Է� - 35��° ��
		bruteForce(space); //(���Ʈ������ �´��� �𸣰�����) ������ Ǯ�� ���� �޼ҵ� ȣ�� - 44��° ��
		sb.append(COUNT); //������ �ִ� StringBuilder�� ����
		
		System.out.println(sb); //�ִ� ���
		
		br.close();
	}
	public static void fillArr(int[][] arr, BufferedReader br) throws IOException {
		for(int i=0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken()); //�ش� �ε����� �ǹ��� ũ�� �Է�
			}
		}
	}
	public static void bruteForce(int[][] arr) {
		int spaceCount = 0; //���� ī��Ʈ
		while(arrSum(arr) != 0) { //���� �迭�� ���� 0�� �� ������ - 59��° ��
			arrSub(arr); //�� ���� 1ĭ��ŭ ������ (��� �迭�� ��� -1) - 66��° ��
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//�湮���� �ʰ� �ش� �ε����� ���� 0�� �ƴϸ�(��, �Ȱ��� ���̸�)
					if(!visited[i][j] && arr[i][j] > 0) {
						spaceCount++; //���� ī��Ʈ 1 ���� (������ ���� ����)
						search(arr, i, j); //����ã�� (4��Ž��) - 76��° ��
					}
				}
			}
			COUNT = Math.max(COUNT, spaceCount); //���� ī��Ʈ�� ���� ���� �� ã��
			setBoolean(visited); //�湮 �迭 �ʱ�ȭ - 88��° ��
			spaceCount = 0; //���� ī��Ʈ �ʱ�ȭ
		}
	}
	public static int arrSum(int[][]arr) { 
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += Arrays.stream(arr[i]).sum(); //���� �迭�� ��
		}
		return sum;
	}
	public static void arrSub(int[][]arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != 0) { //�ش� �ε����� ��Ұ� 0�� �ƴϸ�
					arr[i][j] -= 1; // -1�ϱ� (�ᱹ, �迭�� ��Ҵ� ���� 0�� ��)
				}
			}
		}
	}
	public static void search(int[][] arr, int i, int j) {
		visited[i][j] = true; //�湮�� ������ üũ

		for(int k=0; k<4; k++) {//4��Ž�� (��, ��, ��, ��)����
			int r = rows[k] + i; //rows(x��ǥ)
			int c = cols[k] + j; //cols(y��ǥ)
			if(r >= 0 && c >= 0 && r < N && c < N) {//x��ǥ�� y��ǥ�� �迭 �ȿ� ���� ��
				//�湮���� �ʰ� �ش� �ε����� ���� 0�� �ƴϸ�(��, �Ȱ��� ���̸�) search�Լ� ȣ��(����Լ�)
				if(!visited[r][c] && arr[r][c] > 0) search(arr, r, c); 
			}
		}
	}
	public static void setBoolean(boolean[][] arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = false; //�ش� �ε����� ��Ҹ� false�� �ʱ�ȭ
			}
		}
	}

}
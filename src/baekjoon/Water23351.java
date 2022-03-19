package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Water23351 {
	public static int day = 0; //��¥

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // ȭ���� ����
		int k = Integer.parseInt(st.nextToken()); // �� ȭ�п� ��� �ִ� �ʱ� ���з�
		int a = Integer.parseInt(st.nextToken()); // ���� �� ȭ���� ����
		int b = Integer.parseInt(st.nextToken()); // �� �� ���� �� �� �þ�� ������ ��
		
		ArrayList<Integer> pot = new ArrayList<Integer>(n); //ũ�Ⱑ n�� ArrayList(pot) ����
		for(int i=0; i<n; i++) {
			pot.add(k); //pot�� k��ŭ ä���
		}
		
		greedy(pot, a, b); //greedy�Լ� ȣ��
		System.out.println(day); //��¥ ���
	}
	
	public static void greedy(ArrayList<Integer> list, int a, int b) {
		while(!list.contains(0)) {
			day++; //�Ϸ� ����
			Collections.sort(list); // list���θ� ������������ ����
			for(int i=0; i<a; i++) { //���� �ͺ��� ���� �ֱ� ����
				list.set(i, list.get(i)+b);
			}
			for(int i=0; i<list.size(); i++) {// ���� 1 ����
				list.set(i, list.get(i)-1);
			}
		}
	}
}

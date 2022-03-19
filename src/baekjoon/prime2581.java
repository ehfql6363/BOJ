package baekjoon;

import java.util.Scanner;

public class prime2581 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[] comNum = new int[n-m+1];
		int[] prime = new int[n-m+1];
		
		if(0<m && m<=n && n<=10000) {
			
			if(findPrime(m, n, comNum, prime)==0) { //findPrime�Լ� ȣ��
				System.out.print(-1);
			}else {
				sb.append(findPrime(m, n, comNum, prime)).append("\n");
				sb.append(prime[0]);
			}
		}
		System.out.print(sb.toString().trim());
		
		sc.close();
	}
	
	//�Ҽ� ã�� �Լ�. ��ȯ��(return)���� sum ��ȯ
	public static int findPrime(int startNumber, int endNumber, int[] arr, int[] prime) {
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=2; j<i+startNumber; j++) { //i+startNumber = ���� ��
				if((i+startNumber)%j==0) { //�ռ��� ã��
					arr[i] = i + startNumber; //�ռ����� arr�迭�� �� �ڸ��� ����
					break;
				}
			}
			if(i+startNumber == 1) {
				continue; //startNumber�� 1�ϰ��, �������� �ѱ�
			}
			else if(arr[i]==0) { //�ռ����� �ƴ� �͵�(�Ҽ��� �͵�)
				prime[i] = i + startNumber; //prime�迭�� �� �ڸ��� ����
				sum += prime[i]; //prime�迭�� �ռ��� �ڸ��� 0�̹Ƿ� ������ ���� X
			}
			primeSort(prime); //prime�迭 �߰��� ���ִ� 0 �����ϰ� 0�� �ƴ� ���� �������� ����
		}

		return sum;
	}
	
	public static void primeSort(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			if(a[i]==0) {
				a[i] = a[i+1];//i������ 0�� ������ ������ ��ܼ� 0 ����
			}
		}
	}
}
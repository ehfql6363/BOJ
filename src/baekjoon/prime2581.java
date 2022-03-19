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
			
			if(findPrime(m, n, comNum, prime)==0) { //findPrime함수 호출
				System.out.print(-1);
			}else {
				sb.append(findPrime(m, n, comNum, prime)).append("\n");
				sb.append(prime[0]);
			}
		}
		System.out.print(sb.toString().trim());
		
		sc.close();
	}
	
	//소수 찾기 함수. 반환값(return)으로 sum 반환
	public static int findPrime(int startNumber, int endNumber, int[] arr, int[] prime) {
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=2; j<i+startNumber; j++) { //i+startNumber = 원래 수
				if((i+startNumber)%j==0) { //합성수 찾기
					arr[i] = i + startNumber; //합성수를 arr배열의 각 자리에 저장
					break;
				}
			}
			if(i+startNumber == 1) {
				continue; //startNumber가 1일경우, 다음으로 넘김
			}
			else if(arr[i]==0) { //합성수가 아닌 것들(소수인 것들)
				prime[i] = i + startNumber; //prime배열의 각 자리에 저장
				sum += prime[i]; //prime배열의 합성수 자리는 0이므로 덧셈에 지장 X
			}
			primeSort(prime); //prime배열 중간에 껴있는 0 삭제하고 0이 아닌 수를 오름차순 정렬
		}

		return sum;
	}
	
	public static void primeSort(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			if(a[i]==0) {
				a[i] = a[i+1];//i번지에 0이 있으면 앞으로 당겨서 0 삭제
			}
		}
	}
}
package baekjoon;

import java.util.Scanner;

public class BOJ2792 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int num[] = new int[M]; //보석의 개수를 담은 배열

        int left = 1; //최소 하나
        int right = 0; //최대 질투 값

        for(int i=0; i<M; i++){
            num[i] = sc.nextInt();
            right = Math.max(right, num[i]);
        }

        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            int sum = 0;

            for(int i=0; i<M; i++){
                if(num[i] % mid == 0){
                    sum += num[i]/mid;
                }else{
                    sum += num[i]/mid + 1;
                }
            }

            if(sum > N){
                left = mid+1;
            }else{
                right = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}

package SamsungSDSalgo.DAY2.BOJ2003;

import java.util.Scanner;

public class BOJ2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int high = 0;
        int low = 0;
        while (high < N) {
            int sum = 0;
            for (int i = low; i <= high; i++) {
                sum += arr[i];
            }

            if (sum < M) high++;
            else if (sum > M) low++;
            else{
                count++;
                high++;
                low++;
            }
        }

        System.out.println(count);
    }
}

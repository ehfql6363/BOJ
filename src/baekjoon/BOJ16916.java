package baekjoon;

import java.util.Scanner;

public class BOJ16916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        System.out.println(find(text, pattern));
    }
    static int find(String parent, String pattern) {
        int[] table = makeTable(pattern);
        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0;
        for(int i=0; i< n1; i++) {
            while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(parent.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    idx = table[idx];
                    return 1;
                }else {
                    idx += 1;
                }
            }
        }

        return 0;

    }

    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }

        return table;
    }
}

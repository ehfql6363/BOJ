package SamsungSDSalgo.DAY1.BOJ1062;

import java.io.*;
import java.util.Scanner;

public class BOJ1062 {

    static int N,K;
    static boolean[] visited;
    static String[] word;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/SamsungSDSalgo/DAY1/BOJ1062/input.txt"));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        K = sc.nextInt();

        word = new String[N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            str = str.replaceAll("[antic]", "");
            word[i] = str;
        }

        if(K < 5){
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            return;
        } else if (K == 26) {
            bw.write(String.valueOf(N));
            bw.flush();
            bw.close();
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    static void dfs(int alphaIdx, int depth){

        /*
        DFS 구현 순서
        1. 체크인
        2. 목적지인가?
        3. 연결된 곳을 순회 가능한가?2
            4. 갈 수 있는가?
                5. 간다.
        6. 체크아웃
        */

        if (depth == K - 5) { // 2.
            //배울 수 있는 단어를 모두 배우면 배울 수 있는 단어 개수 체크
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean check = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if(!visited[word[i].charAt(j) - 'a']){
                        check = false;
                        break;
                    }
                }
                if(check) cnt++;
            }
            max = Math.max(max, cnt);
        }

        for (int i = alphaIdx; i < 26; i++) { // 3.
            if(!visited[i]){ // 4.
                visited[i] = true; // 1.
                dfs(i, depth + 1); // 5.
                visited[i] = false; // 6.
            }
        }


    }
}

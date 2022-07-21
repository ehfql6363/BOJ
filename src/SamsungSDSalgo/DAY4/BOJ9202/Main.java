package SamsungSDSalgo.DAY4.BOJ9202;

import java.io.*;

public class Main {

    static int N, count, maxLen, sum;

    static String longWord;
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    static char[][] map = new char[4][4];
    static boolean[][] visited = new boolean[4][4];
    static int[] rows = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] cols = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] score = {0, 0, 1, 1, 2, 3, 5, 7, 11};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            root.insert(br.readLine());
        }
        br.readLine();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                char[] arr = br.readLine().toCharArray();
                for (int k = 0; k < 4; k++) {
                    map[j][k] = arr[k];
                }
            }
            //isHit 클리어 함수
            root.clearHit();
            // 변수 초기화
            init();
            //dfs
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (root.hasChild(map[j][k])){
                        search(j, k, root.child[map[j][k] - 'A']);
                    }
                }
            }
            ans.append(sum).append(" ").append(longWord).append(" ").append(count);
            ans.append("\n");
        }

        bw.write(ans.toString());
        bw.close();
        br.close();
    }

    static class Node{

        boolean isWord = false;
        boolean isHit = false;
        Node[] child = new Node[26];

        void insert(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'A';
                if (node.hasChild(c)) node.child[idx] = new Node();
                node = node.child[idx]; // 노드를 자식 노드로 이동
            }

            node.isWord = true;
        }

        void clearHit() {
            this.isHit = false;
            for (int i = 0; i < this.child.length; i++) {
                if (this.child[i] != null) {
                    this.child[i].clearHit();
                }
            }
        }

        boolean hasChild(char c){
            return this.child[c - 'A'] == null;
        }
    }

    static void search(int r, int c, Node node) {
        visited[r][c] = true; // 체크인
        sb.append(map[r][c]);

        if (node.isWord && !node.isHit) { // 단어를 처음 찾으면
            node.isHit = true;

            // 정답 개수
            count++;

            // 길이가 가장 긴 단어 찾기
            String word = sb.toString();
            int len = word.length();
            maxLen = longWord.length();
            if (maxLen < len) {
                longWord = word;
                maxLen = len;
            }

            // 점수 선정
            sum += score[len - 1];

        }
        for (int i = 0; i < 8; i++) {
            int dr = rows[i] + r;
            int dc = cols[i] + c;

            if (dr >= 0 && dc >= 0 && dr < 4 && dc < 4) {
                if (!visited[dr][dc] && node.child[map[dr][dc] - 'A'] != null) {
                    visited[dr][dc] = true;
                    search(dr,dc,node.child[map[dr][dc] - 'A']);
                }
            }
        }

        visited[r][c] = false; // 체크아웃
        sb.deleteCharAt(sb.length() - 1);
    }

    static void init() {
        longWord = "";
        sum = 0;
        count = 0;
        visited = new boolean[4][4];
    }
}

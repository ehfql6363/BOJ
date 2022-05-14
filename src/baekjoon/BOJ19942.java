package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ19942 {
    public static int N, K=5,ans =Integer.MAX_VALUE;
    public static int [][] nutrients;
    public static int [] minN = new int[4]; // 최저 영양소 기준을 담을 배열
    public static int []select;
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nutrients = new int[N][K]; // N개의 영양분과 금액을 담을 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) minN[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++) {
            select = new int[N];
            brute(0,i,0);
        }
        if(list.size()>0) {
            sb.append(ans).append("\n");
            Collections.sort(list);
            String st1 = list.get(0);
            for(int i=0;i<st1.length();i++) {
                sb.append(st1.charAt(i)).append("");
            }
            bw.write(sb.toString());
        }else {
            bw.write(String.valueOf(-1));
        }
        bw.close();
        br.close();
    }

    public static void brute(int cnt, int sel, int start) {
        if(cnt==sel) {
            isCheck(sel); //조건체크
            return;
        }
        for(int i=start;i<N;i++) {
            select[cnt]=i;
            brute(cnt+1,sel,i+1);
        }

    }

    public static void isCheck(int sel) {
        int price=0;
        int []sum = new int[4];
        for(int i=0;i<sel;i++) {
            sum[0]+=nutrients[select[i]][0];
            sum[1]+=nutrients[select[i]][1];
            sum[2]+=nutrients[select[i]][2];
            sum[3]+=nutrients[select[i]][3];
            price+=nutrients[select[i]][4];
        }

        for(int i=0;i<4;i++) {
            if(minN[i]>sum[i]) return;
        }

        if(ans>=price) {
            if(ans>price) {
                list.clear();
            }
            String str="";
            for(int i=0;i<sel;i++) {
                str+=(select[i]+1+" ");
            }
            list.add(str);
            ans = price;
        }
        return;
    }
}

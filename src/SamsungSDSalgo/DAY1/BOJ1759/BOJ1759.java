package SamsungSDSalgo.DAY1.BOJ1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    public static int L;
    public static boolean[] check;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        check = new boolean[C];

        char[] ch = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<ch.length; i++){
            ch[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(ch);
        pw(ch, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void pw(char[] ch, int start, int len){
        if(len == L){
            int gather = 0;
            int con = 0;

            String str = "";
            for(int i=0; i<ch.length; i++){
                if(check[i]){
                    str += ch[i];

                    if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                        gather++;
                    }else{
                        con++;
                    }
                }
            }
            if(gather >= 1 && con >= 2) sb.append(str).append("\n");
        }

        for(int i=start; i<ch.length; i++){
            check[i] = true;
            pw(ch, i+1, len+1);
            check[i] = false;
        }
    }

}

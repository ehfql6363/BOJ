package programmers;

import java.io.*;

public class PST1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = "";
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String startH, startM, endH, endM, title, music;
        for(int i=0; i<musicinfos.length; i++){
            String[] str = musicinfos[i].split(",");
            String[] sHM = str[0].split(":");
            String[] eHM = str[1].split(":");

            startH = sHM[0];
            startM = sHM[1];

            endH = eHM[0];
            endM = eHM[1];

            title = str[2];
            music = str[3];

            int len;
            if(startH == endH) len = Integer.parseInt(endM) - Integer.parseInt(startM);
            else len = (Integer.parseInt(endH) - Integer.parseInt(startH)) * 60 + Integer.parseInt(endM) - Integer.parseInt(startM);


        }


    }
}

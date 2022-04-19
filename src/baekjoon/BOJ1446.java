package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1446 {
    static class Road{
        int s, e, w;

        public Road(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<>();

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(e > goal) continue; //지름 길 도착지점이 목표 지점보다 멀 때
            if((e-s)<=w) continue; //지름길이 아닐 때
            list.add(new Road(s, e, w));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.s == o2.s) return o1.e - o2.e; // 시작지점이 같으면 도착지점이 작은 순
            return o1.s - o2.s; //시작지점이 작은 순
        });

        int move = 0;//현재 위치(이동한 거리)
        int idx = 0; //지름길 인덱스
        int[] dist = new int[10001]; //지도(?) 인덱스 = 위치, 배열의 값 = 실제 이동한 거리
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        while(move < goal){
            if(idx < list.size()){
                Road road = list.get(idx); //지름길 불러오기
                if(road.s == move) {//지름길이 바로 이어지면
                    dist[road.e] = Math.min(dist[move] + road.w , dist[road.e]);
                    idx++;
                }else{//지름길이 이어지지 않으면
                    dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                    move++;
                }
            }else{
                dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                move++;
            }
        }
        bw.write(String.valueOf(dist[goal]));
        bw.flush();
        bw.close();
        br.close();
    }
}

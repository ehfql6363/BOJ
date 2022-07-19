package SamsungSDSalgo.DAY2.BOJ1713;

import java.util.*;

public class BOJ1713 {

    static Nominee[] nominees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        nominees = new Nominee[101];

        ArrayList<Nominee> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            //해당 후보가 최초 호출 시
            if (nominees[num] == null) {
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            //해당 후보가 사진틀에 있을 경우
            if (nominees[num].isIn){
                nominees[num].count++;
            }else{
                //해당 후보가 사진 틀에 없는 경우
                //사진틀이 가득 찬 경우
                if (list.size() == N) {
                    //정렬, 자율 후보 선정, 제거
                    Collections.sort(list);
                    Nominee nominee = list.remove(0);
                    nominee.isIn = false;
                }
                //사진틀에 여유가 있는 경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = i;
                list.add(nominees[num]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.num));

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).num + " ");
        }
    }
}

class Nominee implements Comparable<Nominee> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Nominee(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "Nominee{" +
                "num=" + num +
                ", count=" + count +
                ", timeStamp=" + timeStamp +
                ", isIn=" + isIn +
                '}';
    }

    //1. 추천 수
    //2. 시간
    @Override
    public int compareTo(Nominee o) {
        int compare = Integer.compare(this.count, o.count);
        if (compare == 0) {
            return Integer.compare(this.timeStamp, o.timeStamp);
        }
        else return compare;
    }
}

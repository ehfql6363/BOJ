package SamsungSDSalgo.DAY2.BOJ1713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);



        //Comparable은 정적, Comparator는 동적으로 수정 가능
        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp); //기존 Comparable은 무시되고 Comparator를 기준으로 정렬
        System.out.println("list = " + list);

        Collections.sort(list, Comparator.comparingInt(Item::getB));
        System.out.println("list = " + list);
        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed());
        System.out.println("list = " + list);

    }
}
class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        //음수 : 바꾸지 않음(원래 순서)
        //0
        //양수 : 바꿈
        if (this.b > o.b) {
            return -1;
        } else if (this.b == o.b) {
            return 0;
        } else{
            return 1;
        }
//        return Integer.compare(this.b, o.b);//기본은 오름차순
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}

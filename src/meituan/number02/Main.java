package meituan.number02;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 15:56
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        PriorityQueue<String> store = new PriorityQueue<>(cmp);

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (Character.isDigit(cur)) {
                int end = i;
                while (end < str.length() && Character.isDigit(str.charAt(end))) {
                    end++;
                }
                int start = i;
                while (start < str.length() && str.charAt(start) == '0') {
                    start++;
                }
                if (start == end) {
                    store.add("0");
                }
                else {
                    String tmp = str.substring(start, end);
                    store.add(tmp);
                }
                i = end;
            }
        }

        while (!store.isEmpty()) {
            System.out.println(store.poll());
        }
    }

    private static Comparator<String> cmp = (o1, o2) -> {
        if (o1.length() < o2.length()) {
            return -1;
        }
        else if (o1.length() == o2.length()) {
            return o1.compareTo(o2);
        }
        else {
            return 1;
        }
    };
}

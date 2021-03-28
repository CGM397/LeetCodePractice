package jd.number01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 18:55
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str == null || str.length() < 1) {
            System.out.println(0);
            return;
        }
        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int num = 1;
            if (i < str.length() - 1) {
                char tmp = str.charAt(i + 1);
                int tmpNum = 0;
                while (Character.isDigit(tmp)) {
                    tmpNum = tmpNum * 10 + (tmp - 48);
                    i++;
                    if (i == str.length() - 1) break;

                    tmp = str.charAt(i + 1);
                }
                num = tmpNum == 0 ? 1 : tmpNum;
            }
            store.put(cur, store.getOrDefault(cur, 0) + num);
        }

        int res = 0;
        Map<Character, Integer> tmpStore = new HashMap<>();
        tmpStore.put('C', 12);
        tmpStore.put('H', 1);
        tmpStore.put('O', 16);
        tmpStore.put('N', 14);
        for (Map.Entry<Character, Integer> entry : store.entrySet()) {
            res += entry.getValue() * tmpStore.get(entry.getKey());
        }
        System.out.println(res);
    }
}

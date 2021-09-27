package huawei.number09;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Bright Chan
 * @date: 2021/9/26 13:49
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        String[] store = new String[] {"14", "8", "1403", "6"};
        System.out.println(getMaxNum(store));
    }

    private static String getMaxNum(String[] store) {
        Arrays.sort(store, comparator);
        StringBuilder res = new StringBuilder();
        for (String one : store) {
            res.append(one);
        }
        return res.toString();
    }

    private static final Comparator<String> comparator = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
}

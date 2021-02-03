package a_note.comparator;

import java.util.Comparator;

/**
 * @author: Bright Chan
 * @date: 2021/2/3 14:22
 * @description: 各种比较器
 */
public class MyComparator {

    public static Comparator<Integer> naturalOrder = Integer::compareTo;

    public static Comparator<Integer> reverseOrder = Comparator.reverseOrder();

    public static Comparator<Integer> awesomeOrder = (o1, o2) -> {
        if (o1 + 1 > o2) return 1;
        else if (o1.equals(o2)) return 0;
        else return -1;
    };

    public static Comparator<int[]> intervalCmp = (o1, o2) -> {
        if (o1[0] > o2[0]) return 1;
        else if (o1[0] == o2[0]) {
            return Integer.compare(o1[1], o2[1]);
        }
        else return -1;
    };
}

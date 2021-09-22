package huawei.number06;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/9/22 9:54
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        int[] store = new int[] {1,1,2,3,4,5,5};
        int m = 4;
        List<Integer> res = getTopM(store, m);
        for (Integer one : res) {
            System.out.print(one + " ");
        }
    }

    private static List<Integer> getTopM(int[] store, int m) {
        Map<Integer, Integer> count = new HashMap<>();
        int len = store.length;
        List<Integer>[] tmp = new List[len + 1];
        for (int i = 0; i < len; i++) {
            tmp[i] = new ArrayList<>();
        }

        for (int one : store) {
            count.put(one, count.getOrDefault(one, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            List<Integer> one = tmp[entry.getValue()];
            one.add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        int num = 0;
        for (int i = len; i >= 0; i--) {
            List<Integer> one = tmp[i];
            if (!one.isEmpty()) {
                for (Integer integer : one) {
                    res.add(integer);
                    num++;
                    if (num == m) {
                        break;
                    }
                }
            }
            if (num == m) {
                break;
            }
        }
        return res;
    }
}

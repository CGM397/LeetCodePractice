package Q301TO350.number347;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/9/7 10:42
 * @description: 堆，哈希表
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> store = new HashMap<>();
        for (int num : nums) {
            if (store.containsKey(num)) {
                store.put(num, store.get(num) + 1);
            } else {
                store.put(num, 1);
            }
        }

        String[] tmp = new String[nums.length + 1];
        Arrays.fill(tmp, "");
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            tmp[entry.getValue()] = tmp[entry.getValue()] + entry.getKey() + ",";
        }

        int count = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (count == k) break;
            if (tmp[i].length() < 1) continue;
            String[] one = tmp[i].split(",");
            if (one.length >= 1) {
                for (int j = 0; j < one.length; j++) {
                    res[count] = Integer.parseInt(one[j]);
                    count++;
                }
            }
        }
        return res;
    }

    public int[] officialTopKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}

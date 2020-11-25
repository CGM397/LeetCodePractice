package Q1351TO1400.number1370;

/**
 * @author: Bright Chan
 * @date: 2020/11/25 13:35
 * @description: 桶计数
 */
public class Solution {
    public String sortString(String s) {
        int[] store = new int[26];
        String dictionary = "abcdefghijklmnopqrstuvwxyz";
        for (char one : s.toCharArray()) {
            int index = dictionary.indexOf(one);
            store[index] += 1;
        }

        for (int i : store) System.out.println(i);

        int count = 0, len = s.length();
        StringBuilder res = new StringBuilder();
        while (count < len) {
            for (int i = 0; i < store.length; i++) {
                if (store[i] > 0) {
                    res.append(dictionary.charAt(i));
                    count++;
                    store[i] -= 1;
                }
            }

            for (int i = store.length - 1; i >= 0; i--) {
                if (store[i] > 0) {
                    res.append(dictionary.charAt(i));
                    count++;
                    store[i] -= 1;
                }
            }
        }

        return res.toString();
    }
}

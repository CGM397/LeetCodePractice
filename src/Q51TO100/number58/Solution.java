package Q51TO100.number58;

/**
 * @author: Bright Chan
 * @date: 2020/9/4 22:26
 * @description: 数组
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) return 0;
        String[] store = s.split(" ");
        return store.length > 0 ? store[store.length - 1].length() : 0;
    }
}

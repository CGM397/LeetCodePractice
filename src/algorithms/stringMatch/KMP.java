package algorithms.stringMatch;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 12:33
 * @description: KMP算法
 */
public class KMP {
    public int[] getNext(String p) {
        char[] store = p.toCharArray();
        int[] next = new int[p.length()];
        // 第0个位置无法回退，只能查询串向前进，所以需要在kmp算法中考虑到这一点
        next[0] = -1;
        // j为当前字符所在位置，k为j回退的位置
        int j = 0, k = -1;
        while (j < p.length() - 1) {
            if (k == -1 || store[j] == store[k]) {
                j++;
                k++;
                // 当当前字符store[j]和回退之后的字符store[k]相同时，
                // 需要跳过k，取next[k]
                if (store[j] == store[k])
                    next[j] = next[k];
                else
                    next[j] = k;
            }
            else {
                k = next[k];
            }
        }
        return next;
    }

    public int kmp(String s, String p) {
        char[] storeS = s.toCharArray();
        char[] storeP = p.toCharArray();
        int[] next = getNext(p);
        int i = 0, j = 0;

        while (i < storeS.length && j < storeP.length) {
            // j == -1的情况：模式串p的第一个字符(j == 0)无法匹配查询串的第i个字符时，
            // j = next[j]，而next[0] == -1，此时需要i++，j也需要归零
            if (j == -1 || storeS[i] == storeP[j]) {
                i++;
                j++;
            }
            // 如果当前字符不匹配，则j回退到next[j]的位置
            else {
                j = next[j];
            }
        }

        if (j == storeP.length) {
            return i - j;
        }
        else {
            return -1;
        }
    }

}

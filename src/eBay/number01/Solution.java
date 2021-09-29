package eBay.number01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/29 18:53
 * @description: TODO
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = maxRepeatSubString(s);
        System.out.println(res);
    }

    public static int maxRepeatSubString(String src) {
        SuffixArray.Suff[] sa = SuffixArray.getSa2(src);
        int[] height = SuffixArray.getHeight(src, sa);
        int maxHeight = 0;
        for (int j : height) {
            if (j > maxHeight) {
                maxHeight = j;
            }
        }
        return maxHeight;
    }
    static class SuffixArray {
        public static Suff[] getSa2(String src) {
            int n = src.length();
            Suff[] sa = new Suff[n];
            for (int i = 0; i < n; i++) {
                sa[i] = new Suff(src.charAt(i), i, src);// 存单个字符,接下来排序
            }
            Arrays.sort(sa);

            int[] rk = new int[n];// suffix array
            rk[sa[0].index] = 1;
            for (int i = 1; i < n; i++) {
                rk[sa[i].index] = rk[sa[i - 1].index];
                if (sa[i].c != sa[i - 1].c)
                    rk[sa[i].index]++;
            }
            for (int k = 2; rk[sa[n - 1].index] < n; k *= 2) {

                final int kk = k;
                Arrays.sort(sa, (o1, o2) -> {
                    // 不是基于字符串比较,而是利用之前的rank
                    int i = o1.index;
                    int j = o2.index;
                    if (rk[i] == rk[j]) {// 如果第一关键字相同
                        if (i + kk / 2 >= n || j + kk / 2 >= n)
                            return -(i - j);// 如果某个后缀不具有第二关键字,那肯定较小,索引靠后的更小
                        return rk[i + kk / 2] - rk[j + kk / 2];

                    } else {
                        return rk[i] - rk[j];
                    }
                });
                rk[sa[0].index] = 1;
                for (int i = 1; i < n; i++) {
                    int i1 = sa[i].index;
                    int i2 = sa[i - 1].index;
                    rk[i1] = rk[i2];
                    try {
                        if (!src.substring(i1, i1 + kk).equals(src.substring(i2, i2 + kk)))
                            rk[i1]++;
                    } catch (Exception e) {
                        rk[i1]++;
                    }
                }
            }
            return sa;
        }

        static int[] getHeight(String src,Suff[] sa){
            // Suff[] sa = getSa2(src);
            int strLength = src.length();
            int []rk = new int[strLength];
            for (int i = 0; i < strLength; i++) {
                rk[sa[i].index] = i;
            }
            int []height = new int[strLength];
            int k = 0;
            for(int i=0;i<strLength;i++){
                int rk_i = rk[i];  // i后缀的排名
                if (rk_i==0) {
                    height[0] = 0;
                    continue;
                }
                int rk_i_1 = rk_i - 1;
                int j = sa[rk_i_1].index;// j是i串字典序靠前的串的下标
                if (k > 0)
                    k--;

                for (; j + k < strLength && i + k < strLength; k++) {
                    if (src.charAt(j + k) != src.charAt(i + k))
                        break;
                }
                height[rk_i] = k;

            }
            return height;
        }

        public static class Suff implements Comparable<Suff> {
            public char c;// 后缀内容
            private final String src;
            public int index;// 后缀的起始下标
            public Suff(char c, int index, String src) {
                this.c = c;
                this.index = index;
                this.src = src;
            }
            @Override
            public int compareTo(Suff o2) {
                return this.c - o2.c;
            }
            @Override
            public String toString() {
                return "Suff{" + "char='" + src.substring(index) + '\'' + ", index=" + index + '}';
            }
        }
    }
}

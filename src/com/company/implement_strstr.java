package com.company;

import java.util.ArrayList;
import java.util.List;

public class implement_strstr {
    public int strStr(String haystack, String needle) {
        if (needle == null) return 0;
        if (haystack.equals(needle)) return 0;
        int s = needle.length();
        for (int i = 0; i <= haystack.length() - s; i ++) {
            if (haystack.substring(i, i + s).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * kmp算法, 失配表
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int next[] = getNext(needle);

        int i = 0, j = 0;
        while (i <= haystack.length() - needle.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length())
            return i - j;
        return -1;
    }

    /**
     * 获取失配表
     * @param needle not null or empty
     * @return
     */
    public int[] getNext(String needle) {
        int l = needle.length();

        int next[] = new int[l + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < l) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}

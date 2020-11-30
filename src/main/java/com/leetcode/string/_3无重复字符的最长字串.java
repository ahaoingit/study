package com.leetcode.string;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author ahao 2020-09-25
 */
public class _3无重复字符的最长字串 {
    public static int lengthOfLongestSubstring(String s) {
        //标识最大长度
        int max = 0;
        for (int i = 0; i < s.length();++i) {
            //用map存 每次遍历的每个字符 用来判断是否重复
            HashSet<Character> set = new HashSet<>();
            for (int j = i ; j < s.length();++j) {
                //不包含放入map 做记录
                if (set.contains(s.charAt(j))) {
                    max = Math.max(set.size(), max);
                    break;
                }else {
                    set.add(s.charAt(j));
                    max = Math.max(set.size(), max);
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringByWindow(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int pwwkew = lengthOfLongestSubstringByWindow(" pwwkew");
        HashSet<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('c');
        characters.add('a');
        System.out.println(characters);
    }
}

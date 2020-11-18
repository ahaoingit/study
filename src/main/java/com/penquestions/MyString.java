package com.penquestions;

/**
 * TODO
 *
 * @author ahao 2020-11-07
 */
public class MyString {
    public static int search(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArr(match);
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }

    private static int[] getNextArr(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


    public static String replace(String src, String old, String target) {
        int newStrLength = src.length() - old.length() + target.length();
        StringBuffer sb = new StringBuffer(newStrLength);
        int begin = search(src, old);
        for (int i = 0 ; i < newStrLength;i++) {
            if (i >= begin && i<begin+target.length()) {
                sb.append(target.charAt(i-begin));
            }else if (i<begin) {
                sb.append(src.charAt(i));
            }else {
                sb.append(src.charAt(i + old.length() - target.length()));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "abc  dbc";
        String B = "c";
        String C = "ad";
        if (search(C , B) != -1) {
            System.out.println("C 不能包含 B ");
            return;
        }
        while (search(A,B) != -1) {
            A = replace(A,B,C);
        }
        System.out.println(A);
    }

}

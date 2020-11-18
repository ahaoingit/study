package com.ahao.algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author ahao 2020-09-24
 */
public class t1_找出一个字符串中符合规定的字串 {
    public static void main(String[] args) {
        String s = "12345abc7894";
        //记录每次循环的非数字字符的位置
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        out:while (i < s.length()-3){
            StringBuilder tmp = new StringBuilder();
            if (s.charAt(i)<='9' && s.charAt(i)>='1') {
                //获取后三个
                for (int j = i; j < i + 4; ++j) {
                    //判断 这个字符串的后三位
                    if (s.charAt(j)>'9'||s.charAt(j)<'1') {
                        i = j+1;
                        continue out;
                    }else {
                        tmp.append(s.charAt(j));
                    }
                }
                //循环走完判断 数字字符串是否满足条件
                if (Integer.parseInt(tmp.toString())<4000) {
                    sb.append(tmp).append(" ");
                }
                i++;
            }else {
                i++;
            }
        }
        System.out.println(sb.toString());

        //当不能重复使用时:使用正则
        String ex = "[0-9]{4}";
        Pattern pattern = Pattern.compile(ex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

}

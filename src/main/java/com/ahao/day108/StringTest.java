package com.ahao.day108;

/**
 * @author ahao
 */
public class StringTest {
    public static void main(String[] args) {
        String str = new String( "1est108mm" );
        //返回下标为3的字母   t
        char c = str.charAt( 2 );
        System.out.println("charAt:"+c);
        //码点?
        int i = str.codePointAt( 1 );
        System.out.println("codePointAt:"+i);
        //匹配开头结尾
        System.out.println(str.endsWith( "ls" ));
    }
}

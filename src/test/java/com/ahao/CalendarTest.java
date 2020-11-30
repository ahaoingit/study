package com.ahao;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * TODO
 *
 * @author ahao 2020-11-27
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        String s = "123";

    }
}

 class Example {
    String str = "good";
    char[] ch = { 'a', 'b', 'c' };
    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + "and");
        System.out.print(ex.ch);
    }
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}


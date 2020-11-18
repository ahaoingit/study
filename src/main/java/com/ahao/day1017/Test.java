package com.ahao.day1017;

        import java.time.DayOfWeek;
        import java.time.LocalDate;

/**
 * @author ahao
 */
public class Test {
    public static void main(String[] args) {
        //时间点 Data 与 日历 LocalData（静态工厂方法）
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //LocalDate的构造方法是私有的
        //LocalDate localDate = new LocalDate();
        LocalDate date = LocalDate.of( 2019, 10, 25 );
        LocalDate localDate = date.plusDays( 1 );
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(localDate);
    }
}

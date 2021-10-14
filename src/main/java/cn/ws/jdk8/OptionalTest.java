package cn.ws.jdk8;

import java.time.LocalDateTime;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-17 19:28
 */
public class OptionalTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        // 修改日期时间
        LocalDateTime setYear = now.withYear(2078);
        System.out.println("修改年份: " + setYear);
        System.out.println("now == setYear: " + (now == setYear));
        System.out.println("修改月份: " + now.withMonth(6));
        System.out.println("修改小时: " + now.withHour(15));
        System.out.println("修改分钟: " + now.withMinute(11));
        // 再当前对象的基础上加上或减去指定的时间
        LocalDateTime localDateTime = now.plusDays(5);
        System.out.println("5天后: " + localDateTime);
        System.out.println("now == localDateTime: " + (now == localDateTime));
        System.out.println("10年后: " + now.plusYears(10));
        System.out.println("20月后: " + now.plusMonths(20));
        System.out.println("20年前: " + now.minusYears(20));
        System.out.println("5月前: " + now.minusMonths(5));
        System.out.println("100天前: " + now.minusDays(100));
    }


}

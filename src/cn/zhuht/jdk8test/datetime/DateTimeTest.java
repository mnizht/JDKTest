package cn.zhuht.jdk8test.datetime;

import java.time.*;

/**
 * author zhuhaitao
 * date 2019/2/22 14:11
 *
 * java.util.Date 是非线性安全的，所有日期类都是可变的。这是java日期类最大的问题之一。
 * 设计很差：java的日期/时间类设计的并不统一，在java.util和java.sql 的包中都有日期类。此外用于格式化和解析的类在java.text包中定义。
 * java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 *
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * Zoned(时区) − 通过制定的时区处理日期时间。
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 **/
public class DateTimeTest {
  public static void main(String[] args) {
    DateTimeTest test = new DateTimeTest();
    //test.testLocalDateTime();
    test.testZonedDateTime();
  }

  public void testLocalDateTime() {
    LocalDateTime currentTime = LocalDateTime.now();
    System.out.println("currentTime:"+currentTime);
    long time1 = currentTime.toEpochSecond(ZoneOffset.of("+8")); //秒数
    long time2 = currentTime.toInstant(ZoneOffset.of("+8")).getEpochSecond();//秒数
    System.out.println("time1:"+time1);
    System.out.println("time2:"+time2);
    Long milliSecond = currentTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();//毫秒数
    System.out.println("milliSecond:"+milliSecond);
    int nanoSecond = currentTime.getNano();//纳秒数
    System.out.println("nanoSecond:"+nanoSecond);

    System.out.println("current time:"+currentTime.withNano(0));//去除纳秒
    System.out.println(currentTime.atOffset(ZoneOffset.of("+8")));
    System.out.println(currentTime.plusNanos(-123));
    System.out.println("nanoSecond:"+currentTime.getNano());

    LocalDate localDate = currentTime.toLocalDate();
    System.out.println(localDate);
    System.out.println(currentTime.getYear()+"年"+currentTime.getMonthValue()+"月"+currentTime.getDayOfMonth()+"日 "
    +currentTime.getHour()+"时"+currentTime.getMinute()+"分"+currentTime.getSecond()+"秒");
    LocalDateTime date2 = currentTime.withYear(2012).withMonth(2).withDayOfMonth(28);
    System.out.println(date2);
    LocalTime localTime1 = LocalTime.of(21,9);
    LocalTime localTime2 = LocalTime.parse("21:59:32");
    System.out.println(localTime1);
    System.out.println(localTime2);
  }

  public void testZonedDateTime(){
    // 获取当前时间日期
    ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
    System.out.println("date1: " + date1);
    ZoneId id = ZoneId.of("Europe/Paris");
    System.out.println("ZoneId: " + id);
    ZoneId currentZone = ZoneId.systemDefault();
    System.out.println("当期时区: " + currentZone);
  }
}

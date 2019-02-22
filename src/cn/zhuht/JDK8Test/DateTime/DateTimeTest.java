package cn.zhuht.JDK8Test.DateTime;

import java.time.*;

/**
 * author zhuhaitao
 * date 2019/2/22 14:11
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

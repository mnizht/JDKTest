package cn.zhuht.jdk8test.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author zhuhaitao
 * @date 2019/7/20 18:34
 */
public class LocalDateTimeTest {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    System.out.println(now.minusDays(-1));
    System.out.println(getStartDay());
    System.out.println(getEndDay());
    System.out.println("aaaaa:"+ now.with(LocalDateTime.MIN));
    System.out.println("MIN:" + LocalDateTime.MIN);

    Instant instant = Instant.parse("2100-01-01T00:00:00.000Z");
    LocalDateTime end = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
    LocalDateTime end2 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    System.out.println(ZoneId.systemDefault().toString());
    System.out.println(end);
    System.out.println(end2);

    System.out.println("===============");
    Instant nn = Instant.parse("2019-10-27T16:00:00.000Z");
    LocalDateTime nnDate = LocalDateTime.ofInstant(nn,ZoneId.systemDefault());
    LocalDateTime nnDate2 = LocalDateTime.ofInstant(nn, TimeZone.getDefault().toZoneId());
    System.out.println(nnDate.getDayOfWeek());
    System.out.println(nnDate2.getDayOfWeek());
  }

  public static LocalDateTime getStartDay(){
    return LocalDateTime.now().with(LocalTime.MIN);
  }

  public static LocalDateTime getEndDay(){
    return LocalDateTime.now().with(LocalTime.MAX);
  }
}

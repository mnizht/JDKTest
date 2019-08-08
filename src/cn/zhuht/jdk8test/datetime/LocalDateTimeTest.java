package cn.zhuht.jdk8test.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

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

    Instant instant = Instant.parse("2100-01-01T00:00:00.000Z");
    LocalDateTime end = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
    System.out.println(ZoneId.systemDefault().toString());
    System.out.println(end);

  }

  public static LocalDateTime getStartDay(){
    return LocalDateTime.now().with(LocalTime.MIN);
  }

  public static LocalDateTime getEndDay(){
    return LocalDateTime.now().with(LocalTime.MAX);
  }
}

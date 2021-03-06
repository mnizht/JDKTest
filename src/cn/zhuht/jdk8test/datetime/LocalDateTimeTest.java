package cn.zhuht.jdk8test.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.TimeZone;

/**
 * @author zhuhaitao
 * @date 2019/7/20 18:34
 */
public class LocalDateTimeTest {
  public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  public static final DateTimeFormatter REMOVE_SECOND_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

  public static void main(String[] args) {

    test07();
  }

  public static void test07() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now.format(DATETIME_FORMATTER));
    System.out.println(now.toLocalTime().format(REMOVE_SECOND_FORMATTER));

  }

  public static void test06() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime fiveDayLater = now.plusDays(5).with(LocalTime.MIN);
    long l = Duration.between(now, fiveDayLater).toDays();
    System.out.println(l);


  }

  public static void test05() {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start;
    System.out.println(start.compareTo(end));

  }

  public static void test04() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now.isAfter(null));

  }

  public static void test03() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    LocalDateTime monday = now.with(DayOfWeek.TUESDAY).with(LocalTime.MIN);
    System.out.println(monday);
  }

  public static void test02() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    LocalDateTime with = now.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue()).with(LocalTime.MIN);
    System.out.println(with);

  }

  public static void test01() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    System.out.println(now.minusDays(-1));
    System.out.println(getStartDay());
    System.out.println(getEndDay());
    System.out.println("aaaaa:" + now.with(LocalDateTime.MIN));
    System.out.println("MIN:" + LocalDateTime.MIN);

    Instant instant = Instant.parse("2100-01-01T00:00:00.000Z");
    LocalDateTime end = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
    LocalDateTime end2 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    System.out.println(ZoneId.systemDefault().toString());
    System.out.println(end);
    System.out.println(end2);

    System.out.println("===============");
    Instant nn = Instant.parse("2019-10-27T16:00:00.000Z");
    LocalDateTime nnDate = LocalDateTime.ofInstant(nn, ZoneId.systemDefault());
    LocalDateTime nnDate2 = LocalDateTime.ofInstant(nn, TimeZone.getDefault().toZoneId());
    System.out.println(nnDate.getDayOfWeek());
    System.out.println(nnDate2.getDayOfWeek());
  }

  public static LocalDateTime getStartDay() {
    return LocalDateTime.now().with(LocalTime.MIN);
  }

  public static LocalDateTime getEndDay() {
    return LocalDateTime.now().with(LocalTime.MAX);
  }
}

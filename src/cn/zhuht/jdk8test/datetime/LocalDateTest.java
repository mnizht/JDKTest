package cn.zhuht.jdk8test.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * @author zhuhaitao
 * @date 2019/10/29 15:25
 */
public class LocalDateTest {
  public static void main(String[] args) {
    method03();
  }


  public static void method03() {
    String businessId = "141251243151245";
    LocalDateTime now = LocalDateTime.now();
    System.out.println(businessId.concat(now.toString()));
  }

  public static void method02() {
    int value = LocalDate.now().getDayOfWeek().getValue();
    int value1 = LocalDateTime.now().getDayOfWeek().getValue();
    System.out.println(value);
    System.out.println(value1);

  }

  public static void method01() {
    LocalDate date = LocalDate.now();
    LocalDate monday = date.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue());
    System.out.println(monday.toString());
    System.out.println(monday.plusDays(6));

    System.out.println(String.format("%tF-%d", date, 2));
  }
}

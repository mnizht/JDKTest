package cn.zhuht.jdk8test.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @author zhuhaitao
 * @date 2019/10/29 15:25
 */
public class LocalDateTest {
  public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    LocalDate monday = date.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue());
    System.out.println(monday.toString());
    System.out.println(monday.plusDays(6));

    System.out.println(String.format("%tF-%d",date,2));
  }
}

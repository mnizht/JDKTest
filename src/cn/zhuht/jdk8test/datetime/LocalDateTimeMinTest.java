package cn.zhuht.jdk8test.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author zhuhaitao
 * @date 2019/9/12 15:19
 */
public class LocalDateTimeMinTest {
  public static void main(String[] args) {
    System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
    System.out.println(LocalDateTime.now().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.MIN)));
  }
}

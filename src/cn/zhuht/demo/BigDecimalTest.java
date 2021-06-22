package cn.zhuht.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhuht
 * @date 2021/6/17 19:24
 */
public class BigDecimalTest {
  public static void main(String[] args) {
    method01();
  }

  public static void method01() {
    long amount = 2000;
    int period = 30;
    long l = new BigDecimal(amount).divide(new BigDecimal(period), 0, RoundingMode.HALF_UP).longValue();
    System.out.println(l);
    System.out.println(amount / period);

  }
}

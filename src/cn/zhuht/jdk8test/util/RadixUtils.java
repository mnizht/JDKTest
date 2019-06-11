package cn.zhuht.jdk8test.util;

import java.time.LocalDateTime;

/**
 * @author zhuhaitao
 * @date 2019/6/9 14:34
 * 进制转换类
 */
public class RadixUtils {
  static final char[] digits = {
    '0', '1', '2', '3', '4', '5',
    '6', '7', '8', '9', 'a', 'b',
    'c', 'd', 'e', 'f', 'g', 'h',
    'i', 'j', 'k', 'l', 'm', 'n',
    'o', 'p', 'q', 'r', 's', 't',
    'u', 'v', 'w', 'x', 'y', 'z',
    'A', 'B', 'C', 'D', 'E', 'F',
    'G', 'H', 'I', 'J', 'K', 'L',
    'M', 'N', 'O', 'P', 'Q', 'R',
    'S', 'T', 'U', 'V', 'W', 'X',
    'Y', 'Z'
  };

  public static String convert10to62(long i) {
    int radix = 62;
    byte[] buf = new byte[15];
    int charPos = 14;
    boolean negative = (i < 0);

    if (!negative) {
      i = -i;
    }

    while (i <= -radix) {
      buf[charPos--] = (byte) digits[(int) (-(i % radix))];
      i = i / radix;
    }
    buf[charPos] = (byte) digits[(int) (-i)];

    return new String(buf).trim();
  }

  public static String convert10to622(long i) {
    int radix = 62;
    byte[] buf = new byte[15];
    int charPos = 14;

    while (i >= radix) {
      buf[charPos--] = (byte) digits[(int) ((i % radix))];
      i = i / radix;
    }
    buf[charPos] = (byte) digits[(int) (i)];

    return new String(buf).trim();
  }

  public static void thread1(){
    System.out.println("正数开始"+ LocalDateTime.now());
    for(long i = 1L;i<999999999;i++){
      convert10to62(i);
    }
    System.out.println("正数结束"+ LocalDateTime.now());
  }
  public static void thread2(){
    System.out.println("负数开始"+ LocalDateTime.now());
    for(long i = 1L;i<999999999;i++){
      convert10to62(i);
    }
    System.out.println("负数结束"+ LocalDateTime.now());
  }
  public static void main(String[] args) {
    new Thread(RadixUtils::thread1,"正数计算").start();
    new Thread(RadixUtils::thread2,"负数计算").start();
    new Thread(RadixUtils::thread1,"正数计算").start();
    new Thread(RadixUtils::thread2,"负数计算").start();

    System.out.println("2%5="+2%5);
    System.out.println("5%2="+5%2);
    System.out.println("(-2)%(-5)="+(-2)%(-5));
    System.out.println("(-5)%(-2)="+(-5)%(-2));
    System.out.println("2%(-5)="+2%(-5));
    System.out.println("(-2)%5="+(-2)%5);
    System.out.println("5%(-2)="+5%(-2));
    System.out.println("(-5)%2="+(-5)%2);

  }
}

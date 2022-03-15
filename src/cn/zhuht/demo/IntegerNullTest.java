package cn.zhuht.demo;

/**
 * @author zhuht
 * @date 2022/3/2 11:19
 */
public class IntegerNullTest {
  public static void main(String[] args) {
    Num n1 = new Num();
    long ss = n1.a + n1.b;
    System.out.println(ss);
  }

  static class Num{
    int a;
    int b;
  }
}


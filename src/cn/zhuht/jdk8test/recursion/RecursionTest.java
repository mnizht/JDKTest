package cn.zhuht.jdk8test.recursion;

/**
 * @author zhuhaitao
 * @date 2019/11/8 15:20
 */
public class RecursionTest {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    System.out.println(m1(10));
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }


  public static long m1(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    return (m1(n - 2) + m1(n - 1)) % 10007;
  }
}

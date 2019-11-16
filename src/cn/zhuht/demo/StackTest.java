package cn.zhuht.demo;

/**
 * @author zhuhaitao
 * @date 2019/11/8 17:54
 */
public class StackTest {
  public static void main(String[] args) {
    System.out.println(f123(21500));
  }

  private static int fore(int i) {
    int sum = 0;
    for (int i1 = i; i1 > 0; i1--) {
      sum += i1;
    }
    return sum;
  }

  private static int f123(int i) {
    if (i == 1) {
      return 1;
    } else {
      return f123(i - 1) + i;
    }
  }
}

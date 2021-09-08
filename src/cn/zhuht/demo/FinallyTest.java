package cn.zhuht.demo;

/**
 * @author zhuht
 * @date 2021/9/8 17:12
 */
public class FinallyTest {
  public static void main(String[] args) {
    String s = "sss";
    try {
      if (s.length() > 1) {
        return;
      }
      int i = Integer.parseInt(s);
      System.out.println(i);
      return;
    } catch (Exception e) {
      System.out.println(e.toString());
    } finally {
      System.out.println("finally");
    }

  }
}

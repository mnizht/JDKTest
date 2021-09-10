package cn.zhuht.demo;

/**
 * @author zhuht
 * @date 2021/9/8 18:35
 */
public class FinallyTest2 {

  public String ff() {
    String s = "sss";
    try {
      if (s.length() > 1) {
        return "f1";
      }
      int i = Integer.parseInt(s);
      System.out.println(i);
      return "f2";
    } catch (Exception e) {
      System.out.println(e.toString());
    } finally {
      System.out.println("finally");
      return "f3";
    }
  }
}

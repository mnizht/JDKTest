package cn.zhuht.jdk8test.operator;

/**
 * @author zhuhaitao
 * @date 2019/7/30 16:30
 * 运算符测试
 */
public class OperatorTest {
  public static void main(String[] args) {
    int a = 20;
    int b = 10;
    int c = 30;
    int max = (a > b ? a : b) > c ? (a > b ? a : b) : c;
    System.out.println(max);


  }
}

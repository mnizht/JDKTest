package cn.zhuht.JDK8Test.Optional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * author zhuhaitao
 * date 2019/2/22 10:49
 **/
public class OptionalTest {
  public static void main(String[] args) {
    OptionalTest test = new OptionalTest();
    Integer value1 = null;
    Integer value2 = new Integer(10);
    //Optional.ofNullable 允许传递为null的参数
    Optional<Integer> a = Optional.ofNullable(value1);
    //Optional.of 如果参数是null，抛出 NullPointerException
    Optional<Integer> b = Optional.of(value2);
    System.out.println(test.sum(a,b));
  }
  public int sum(Optional<Integer> a,Optional<Integer> b){
    return a.orElse(new Integer(0))+b.orElse(new Integer(0));
  }
}

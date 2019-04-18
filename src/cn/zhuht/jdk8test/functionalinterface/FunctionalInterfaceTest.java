package cn.zhuht.jdk8test.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * author zhuhaitao
 * date 2019/2/21 15:39
 **/
public class FunctionalInterfaceTest {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println("输出所有数据:");
    eval(list, n -> true);
    System.out.println("输出所有偶数：");
    eval(list, n -> n % 2 == 0);
    System.out.println("输出所有大于3的数:");
    eval(list, n -> n > 3);
  }

  public static void eval(List<Integer> list, Predicate<Integer> predicate) {
//    for (Integer n : list) {
//      if (predicate.test(n)) {
//        System.out.println(n + " ");
//      }
//    }
    list.stream().filter(predicate).forEach(System.out::println);
  }
}

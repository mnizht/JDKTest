package cn.zhuht.jdk8test.functionalinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * author zhuhaitao
 * date 2019/2/19 17:19
 * JDK 8虽然有四十几个函数式接口，但都是根据不同用途对这四个接口进行的扩展
 * <p>
 * 函数式接口                参数类型    返回类型          用途
 * Consumer<T>:消费型接口      T           void        对类型为T的对象应用操作。包含方法：void accept(T t)
 * Supplier<T>:供给型接口      void          T         返回类型为T的对象。包含方法：T get()
 * Function<T>:函数型接口      T            R          对类型为T的对象应用操作，并返回R类型的对象。包含方法：R apply(T t)
 * Predicate<T>:断定型接口     T           boolean     确定类型为T的对象是否满足约束条件，返回boolean值。boolean test(T t)
 **/
public class SysFuncInterMathReferenceTest {
  //Consumer<T> 消费型接口
  @Test
  public void testConsumer() {
    //匿名函数方式
    Consumer<Double> con = m -> System.out.println("money=" + m);
    con.accept(123.50);

    //lambda 表达式作为参数传递
    double d = 1000;
    happy(d, m -> System.out.println("money=" + m));
  }

  private void happy(double d, Consumer<Double> con) {
    con.accept(d);
  }

  //Supplier<T> 供给型接口
  @Test
  public void testSupplier() {
    int num = 10;
    List<Integer> list = getNumList(num, () -> (int) (Math.random() * 100));
    System.out.println(list);
    List<Integer> list2 = getNumList(8, () -> new Date().hashCode());
    System.out.println(list2);
  }

  //按指定方式生成指定数量的整数并放在集合中
  private List<Integer> getNumList(int num, Supplier<Integer> sup) {
    List<Integer> list = new ArrayList<>();
    while (list.size() < num) {
      list.add(sup.get());
      list = new ArrayList<>(new HashSet<>(list));
    }
    Collections.sort(list);
    return list;
  }


  //Function<T,R>:函数型接口
  @Test
  public void testFunction() {
    String newStr = strHandler("挖坑埋你   ", String::trim);
    System.out.println(newStr);

    String subStr = strHandler("挖坑埋你", (str) -> str.substring(1, 2));
    System.out.println(subStr);
  }

  //用于处理字符串
  private String strHandler(String str, Function<String, String> func) {
    return func.apply(str);
  }

  // Predicate<T>:断言型接口
  @Test
  public void testPredicate() {
    List<String> list = Arrays.asList("Hello", "waKengMaiNi", "Lambda", "www", "ok");
    List<String> strList = filterStr(list, (s) -> s.length() > 3);

    for (String str : strList) {
      System.out.println(str);
    }
  }

  // 需求：将满足条件的字符串，放入集合中
  private List<String> filterStr(List<String> list, Predicate<String> pre) {
    List<String> strList = new ArrayList<>();

    for (String str : list) {
      if (pre.test(str)) {
        strList.add(str);
      }
    }
    return strList;
  }
}

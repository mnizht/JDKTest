package cn.zhuht.jdk8test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author zhuhaitao
 * date 2019/3/26 16:20
 **/
public class ListTest {
  public static void main(String[] args) {
//    String[] strs = {"孙悟空","猪八戒","沙和尚","唐僧","蜘蛛精","白骨精"};
//    List<String> stringList = Arrays.asList("孙悟空","猪八戒","沙和尚","唐僧","蜘蛛精","白骨精");
//    System.out.println(stringList.get(-1));

//    method3();
//    method4();
//    method5();

//    method6();
    method8();
  }

  private static void method1() {
    List<String> list1 = new ArrayList<>();
    list1.add("aa");
    List<String> list2 = Arrays.asList("aa");
    List<String> list3 = Collections.singletonList("aa");

//    list1.add("bb");
//    list2.add("bb");
//    list3.add("bb");

    String userId = "asdafsaf";
    int size = 11;
    int firstResult = 2;
    int maxResults = 90;
    // System.out.println(String.format("获取个人:%s代办任务结果长度: %d,firstResult:%d,maxResult:%d",userId, size,firstResult,maxResults));

    List<String> ll = null;
    ll.forEach(x -> System.out.println(x));
    System.out.println("end");
  }

  private static void method2() {
    List<String> strings = new ArrayList<>();
    strings.add(null);
    strings.add("cccc");
    strings.add("aaaa");
    strings.add(null);
    strings.add(null);
    strings.removeAll(Collections.singleton(null));
    System.out.println(strings);

    Integer aa = 1;
    Integer bb = 1;
    System.out.println(aa.equals(bb));
  }

  private static void method3() {
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    List<String> list2 = new ArrayList<>();
    list2.add("cc");
    list2.add("bb");

    list.removeAll(list2);
    System.out.println(list);
  }

  private static void method4() {
    List<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bb");
    list.add("c");
    String msg = String.format("本次关闭的订单数量为:%d,关闭的订单id为:%s", list.size(), list.toString());
    System.out.println(msg);
  }

  private static void method5() {
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list2.add("aa");

    System.out.println(list2.stream().filter(x -> list.contains(x)).collect(Collectors.toList()));

  }

  private static void method6() {
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    list.add("dd");
    list.add("ee");
    List<String> stringList = list.subList(0, 2);
    System.out.println(stringList);
  }

  private static void method7() {
    List<String> rule = new ArrayList<>();
    rule.add("主管理员");
    rule.add("子管理员");
    rule.add("主管");
    rule.add("负责人");

    List<String> roles = new ArrayList<>();
    roles.add("主管");
    roles.add("主管理员");
    roles.add("负责人");

    rule.retainAll(roles);

    System.out.println(rule);
  }

  private static void method8() {
    List<String> rule = new ArrayList<>();
    rule.add("主管理员");
    rule.add("子管理员");
    rule.add("主管");
    rule.add("负责人");

    List<String> subList = rule.subList(0, Math.min(rule.size(), 20));

    System.out.println(subList);
  }
}

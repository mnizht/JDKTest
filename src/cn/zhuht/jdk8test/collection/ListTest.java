package cn.zhuht.jdk8test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author zhuhaitao
 * date 2019/3/26 16:20
 **/
public class ListTest {
  public static void main(String[] args) {
//    String[] strs = {"孙悟空","猪八戒","沙和尚","唐僧","蜘蛛精","白骨精"};
//    List<String> stringList = Arrays.asList("孙悟空","猪八戒","沙和尚","唐僧","蜘蛛精","白骨精");
//    System.out.println(stringList.get(-1));

    method3();

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

  private static void method3(){
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    List<String> list2 = new ArrayList<>();
    list2.add("cc");
    list2.add("bb");

    list.removeAll(list2);
    System.out.println(list);
  }
}

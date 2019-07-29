package cn.zhuht.jdk8test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhuhaitao
 * @date 2019/7/23 17:37
 */
public class SetTest {
  public static void main(String[] args) {
    Set<String> set1 = new HashSet<>();
    set1.add("aaa");
    set1.add("bbb");
    set1.add("ccc");
    set1.add("ddd");

    System.out.println(set1);

    List<String> list1 = null;
    //set1.addAll(list1);

    List<String> list2 = new ArrayList<>();
    list2.add("aaa");
    list2.add("eee");
    list2.add("eee");
    list2.add("abc");
    set1.addAll(list2);
    System.out.println(set1);

  }
}

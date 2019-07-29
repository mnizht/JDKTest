package cn.zhuht.jdk8test.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuhaitao
 * @date 2019/7/18 11:12
 */
public class CollectionsTest {
  public static void main(String[] args) {
    Set<String> set1 = new HashSet<>();
    set1.add("aaa");
    set1.add("bbb");
    set1.add("ccc");
    set1.add("ddd");

    Set<String> set2 = new HashSet<>();
    set2.add("ddd");
    set2.add("eee");

    System.out.println(set1.containsAll(set2));
    System.out.println(set1.retainAll(set2));
    System.out.println(set1);

  }
}

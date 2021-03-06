package cn.zhuht.jdk8test.functionalinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author zhuhaitao
 * date 2019/2/19 15:19
 **/
public class MyFuncMathReferenceTest {

  @Test
  public void testGetValue() {
    String str = "abcdef";
    String newStr = toUpperString(String::toUpperCase, str);
    System.out.println(newStr);
  }

  @Test
  public void testGetValue2() {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2, 5, 2));
//    Collections.sort(list);
//    System.out.println(list);
    System.out.println(sortMF(x -> localSort(x), list));
  }

  private String toUpperString(MyFunc<String> mf, String str) {
    return mf.getValue(str);
  }

  private List<Integer> sortMF(MyFunc<List<Integer>> mf, List<Integer> list) {
    return mf.getValue(list);
  }

  private List<Integer> localSort(List<Integer> list) {
    Collections.sort(list);
    return list;
  }
}

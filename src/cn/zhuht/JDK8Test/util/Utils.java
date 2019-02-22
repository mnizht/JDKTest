package cn.zhuht.JDK8Test.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author zhuhaitao
 * date 2019/2/22 15:14
 **/
public class Utils {
  public static void main(String[] args) {

    String id = "30e9b4dc34dd11e9ac8e12f0053031f8";
    List<String> ids = Arrays.asList("30e9b4dc34dd11e9ac8e12f0053031f8", "650b8c0534f811e99f5b12f0053031f8",
      "8400ae5b34db11e9ac8e12f0053031f8", "a3867456357e11e9849c505bc2bd8bdf");
    System.out.println(Utils.countChar(id));
    System.out.println(Utils.countChar(ids));
  }

  /**
   * 统计字符串中各个字符数量
   */
  public static Map<Character, Integer> countChar(String str) {
    Map<Character, Integer> map = new HashMap<>();
    count(map, str);
    return map;
  }

  public static Map<Character, Integer> countChar(List<String> strs) {
    Map<Character, Integer> map = new HashMap<>();
    for (String str : strs) {
      count(map, str);
    }
    return map;
  }

  private static void count(Map<Character, Integer> map, String str) {
    char[] chars = str.toCharArray();
    for (char c : chars) {
      map.put(c, (map.get(c) == null ? 0 : map.get(c)) + 1);
    }
  }
}

package cn.zhuht.jdk8test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author haitao zhu
 * @date 2020/7/3 11:35
 */
public class StreamTest {
  public static void main(String[] args) {
    method02();
  }

  public static void method02() {
    List<String> names = new ArrayList<>();
    List<String> collect = names.stream().skip(10).limit(10).collect(Collectors.toList());
    System.out.println(collect);
  }

  public static void method01() {
    Map<String, List<String>> map = new HashMap<>();
    map.put("AA", Arrays.asList("A1", "A2", "A3"));
    map.put("BB", Arrays.asList("B1", "B2"));
    map.put("CC", Arrays.asList());
    map.put("DD", Arrays.asList("D1", "B2", "A3"));

    Set<String> collect = map.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    System.out.println(collect);

    map.get(null);
  }
}

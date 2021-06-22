package cn.zhuht.jdk8test.lambda;

import cn.zhuht.jdk8test.pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author haitao zhu
 * @date 2020/7/3 11:35
 */
public class StreamTest {
  public static void main(String[] args) {
    method05();
  }

  public static void method05(){
    List<User> of = List.of();
    List<User> emptyList = Collections.emptyList();
    List<String> collect = of.stream().map(User::getName).collect(Collectors.toList());
    List<String> collect2 = emptyList.stream().map(User::getName).collect(Collectors.toList());

  }

  public static void method04(){
    User user1 = new User().setName("zhangsan");
    User user2 = new User().setName(null);
    User user3 = new User().setName(null);

    List<User> users = Arrays.asList(user1, user2, user3);
    Set<String> names = users.stream().map(User::getName).collect(Collectors.toSet());
    System.out.println(names);
  }

  public static void method03() {
    User user1 = new User().setName("战三").setOldName("张三");
    User user2 = new User().setName("法外狂徒").setOldName("枪火狂徒");
    List<User> userList = Arrays.asList(user1, user2);
    Set<String> collect = userList.stream().flatMap(u -> Stream.of(u.getName(), u.getOldName()))
      .collect(Collectors.toSet());
    System.out.println(collect);
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

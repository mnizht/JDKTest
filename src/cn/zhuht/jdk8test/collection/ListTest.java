package cn.zhuht.jdk8test.collection;

import cn.zhuht.jdk8test.pojo.Org;
import cn.zhuht.jdk8test.pojo.User;
import com.alibaba.fastjson.JSONArray;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author zhuhaitao
 * date 2019/3/26 16:20
 **/
public class ListTest {
  public static void main(String[] args) {
    method19();
  }

  public static void method19() {
    List<String> studentNames = Arrays.asList("张三", "李四", "王五", "赵六", "田七");
    if (studentNames.size() > 4) {
      System.out.println(String.join(",", studentNames.subList(0, 4)) + "...");
    } else {
      System.out.println(String.join(",", studentNames.subList(0, studentNames.size())));
    }
  }

  public static void method18() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    String str = JSONArray.toJSONString(integers);
    System.out.println(str);
  }

  public static void method17() {
    List<User> list1 = new ArrayList<>(50000);
    List<User> list2 = new ArrayList<>(500000);
    for (int i = 0; i < 50000; i++) {
      list1.add(new User(String.valueOf(i), i));
    }
    for (int i = 500000; i > 0; i--) {
      list1.add(new User(String.valueOf(i), i));
    }
    List<User> list3 = new ArrayList<>(list2);
    Set<String> name1 = list1.stream().map(User::getName).collect(Collectors.toSet());
    long l1 = System.currentTimeMillis();

    Map<String, User> map1 = list2.stream().collect(Collectors.toMap(User::getName, u -> u));
    list1.forEach(user ->
      map1.get(user.getName())
    );
    long l2 = System.currentTimeMillis();

    Map<String, User> map2 = list3.stream().filter(user -> name1.contains(user.getName()))
      .collect(Collectors.toMap(User::getName, u -> u));
    list1.forEach(user ->
      map2.get(user.getName())
    );


    long l3 = System.currentTimeMillis();

    System.out.println(String.format("l2 - l1 = %d", l2 - l1));
    System.out.println(String.format("l3 - l2 = %d", l3 - l2));

  }

  public static void method16() {
    String str1 = "学员姓名：张三 &update; 李四";
    String str2 = "学员年级：一年级 &update; 二年级";
    String str3 = "学员年龄：13 &update; 14";

    List<String> list = Arrays.asList(str1, str2, str3);
    String s = JSONArray.toJSONString(list);
    System.out.println("content=" + s);

    List<String> parse = (List<String>) JSONArray.parse(s);
    parse.forEach(System.out::println);
  }

  public static void method15() {
    User user = new User("aa", 10);
    User user2 = new User("aa", 55);
    User user3 = new User("aa", 20);
    User user4 = new User("bb", 20);
    User user5 = new User("bb", 15);
    User user6 = new User("bb", 30);
    User user7 = new User("bb", 10);
    User user8 = new User("cc", 25);
    User user9 = new User("cc", 10);

    List<User> users = Arrays.asList(user, user2, user3, user4, user5, user6, user7, user8, user9);
    Map<String, List<User>> map = users.stream().sorted(Comparator.comparingInt(User::getAge))
      .collect(Collectors.groupingBy(User::getName));
    map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue().toString()));
  }

  public static void method14() {
    Set<String> set = new HashSet<>();
    List<String> list = new ArrayList<>();
    System.out.println(set.containsAll(list));
    System.out.println(list.containsAll(set));
  }

  public static void method13() {
    List<String> list = new ArrayList<>();
    list.add(null);
    Collections.sort(list);
  }

  private static void method12() {
    List<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    System.out.println(list.toString());
    HashSet<String> strings = new HashSet<>(list);
    Set<String> set = new HashSet<>();
    System.out.println(set.containsAll((Collection) null));
    System.out.println(set.equals(new HashSet<>(null)));

    set.add("aa");
    set.add("bb");

    set.add("dd");
    System.out.println(strings.equals(set));
  }

  private static void method11() {
    LocalDateTime now = LocalDateTime.now();
    User user1 = new User("AA", 1, 10.0, now);
    User user2 = new User("AA", 2, 10.0, now.minusDays(1));
    User user3 = new User("AA", 3, 10.0, now.minusDays(2));
    User user4 = new User("AA", 4, 10.0, now.minusDays(3));
    User user5 = new User("BB", 5, 10.0, now.minusDays(4));
    User user6 = new User("BB", 6, 10.0, now.minusDays(5));
    User user7 = new User("BB", 7, 10.0, now.minusDays(6));
    User user8 = new User("CC", 8, 10.0, now.minusDays(7));
    User user9 = new User("CC", 9, 10.0, now.minusDays(8));

    List<User> list = Arrays.asList(user3, user2, user7, user9, user4, user6, user1, user8, user5);
    Map<String, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getName));
    for (Map.Entry<String, List<User>> entry : collect.entrySet()) {
      List<User> value = entry.getValue();
      System.out.println("value = " + value.toString());
      value.sort(Comparator.comparing(User::getBirthday).reversed());
      System.out.println("value2 = " + value.toString());

    }

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

  private static void method9() {
    Org org1 = new Org("000105");
    Org org2 = new Org("00010601");
    Org org3 = new Org("00010603");
    Org org4 = new Org("000102");
    Org org5 = new Org("0001");
    Org org6 = new Org("00010604");
    Org org7 = new Org("00010605");
    Org org8 = new Org("000101");

    List<Org> list = new ArrayList<>();
    list.add(org1);
    list.add(org2);
    list.add(org3);
    list.add(org4);
    list.add(org5);
    list.add(org6);
    list.add(org7);
    list.add(org8);
    System.out.println(list);
    list = list.stream().sorted(Comparator.comparing(Org::getOrgNum)).collect(Collectors.toList());
    System.out.println(list);
  }

  private static void method10() {
    List<String> list = new ArrayList<>();
    list.add("6619797633647120384");

    List<String> list2 = new ArrayList<>();
    list2.add("6619797632938283008");

    list.removeAll(list2);
    System.out.println(list);
  }
}

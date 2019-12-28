package cn.zhuht.jdk8test.collection;

import cn.zhuht.jdk8test.pojo.User;
import com.alibaba.fastjson.serializer.MapSerializer;
import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuhaitao
 * @date 2019/10/29 10:24
 */
public class MapTest {
  public static void main(String[] args) {

//    method02();
    method03();
  }

  private static void method01() {
    Map<String, String> map = new HashMap<>();
    map.put("aa", "aaa");
    String bb = map.get("bb");
    System.out.println(bb);

    String num = "00010203";
    System.out.println(num.substring(0, num.length() - 2));
    System.out.println(num.substring(0, num.length() - 4));
    System.out.println(num.substring(0, 2));
  }

  private static void method02() {

    Map<String, User> userMap = new HashMap<>();
    User user1 = new User("aa", 12, 70.0);
    User user2 = new User("bb", 12, 70.0);
    User user3 = new User("cc", 12, 70.0);

    userMap.put(user1.getName(), user1);
    userMap.put(user2.getName(), user2);
    userMap.put(user3.getName(), user3);

    String name = "dd";
    while (null == userMap.get(name)) {
      User user = new User(name, 23, 30.9);
      userMap.put(name, user);
    }
    System.out.println(userMap);


  }

  private static void method03() {
    Set<String> set1 = new HashSet<>();
    set1.add("aa");
    set1.add("bb");
    set1.add("cc");
    Set<String> set2 = new HashSet<>();
    set1.add("aa");
    set1.add("cc");
    set1.add("dd");
    Set<String> set3 = new HashSet<>();
    set1.add("dd");
    set1.add("cc");
    Map<String, Set<String>> map1 = new HashMap<>();
    map1.put("AA", set1);
    map1.put("BB", set2);
    map1.put("CC", set1);
    Map<String, Set<String>> map2 = new HashMap<>();
    map2.put("BB", set1);
    map2.put("CC", set3);

    Map<String,Set<String>> map3 = new HashMap<>();
    System.out.println(map3);
    for(Map.Entry<String,Set<String>> entry:map3.entrySet()){
      System.out.println("aa");
    }

  }


}

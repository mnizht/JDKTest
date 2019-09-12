package cn.zhuht.jdk8test.lambda;

import cn.zhuht.jdk8test.pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhuhaitao
 * @date 2019/9/12 18:14
 */
public class ListToMapTest {
  public static void main(String[] args) {
    User user1 = new User("aaa", 10, 10.0);
    User user2 = new User("aaa", 11, 10.0);
    User user3 = new User("bbb", 10, 10.0);
    User user4 = new User("ccc", 9, 10.0);
    User user5 = new User("ccc", 10, 10.0);

    List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
    Map<String, User> userMap = list.stream().collect(Collectors.toMap(User::getName, x -> x, (s, a) -> s));
    System.out.println(userMap);
  }
}

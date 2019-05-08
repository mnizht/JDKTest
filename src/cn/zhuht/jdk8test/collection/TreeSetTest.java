package cn.zhuht.jdk8test.collection;

import cn.zhuht.jdk8test.pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author zhuhaitao
 * @date 2019/5/8 16:25
 */
public class TreeSetTest {
  public static void main(String[] args) {
    User user1 = new User("aa", 1);
    User user2 = new User("bb", 2);
    User user3 = new User("cc", 3);
    User user4 = new User("dd", 4);
    User user5 = new User("ee", 5);
    List<User> list = Arrays.asList(user1, user2, user3, user4, user5);

    ArrayList<Integer> collect = list.stream().map(User::getAge).collect(Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), ArrayList::new));

    System.out.println(collect);
  }
}

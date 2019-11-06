package cn.zhuht.jdk8test.lambda;

import cn.zhuht.jdk8test.pojo.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuhaitao
 * @date 2019/9/10 16:54
 */
public class ReduceTest {
  public static void main(String[] args) {
    User user1 = new User("aaa",10,10.5);
    User user2 = new User("aaa",20,10.5);
    User user3 = new User("aaa",30,10.5);
    List<User> users = Arrays.asList(user1,user2,user3);
    Integer age1 = users.stream().map(User::getAge).reduce(0,Integer::sum);
    Integer age2 = users.stream().mapToInt(User::getAge).sum();

    System.out.println(age1);
    System.out.println(age2);
  }
}

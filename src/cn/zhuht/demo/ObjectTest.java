package cn.zhuht.demo;

import cn.zhuht.jdk8test.pojo.User;

/**
 * @author zhuhaitao
 * @date 2019/8/28 9:36
 */
public class ObjectTest {
  public static void main(String[] args) {
    method02();
  }

  public static void method02() {
    User user = new User("aa", 10);
    User user2 = new User("bb", 10);

    System.out.println(user.getAge().equals(user2.getAge()));

  }

  public static void method01() {
    User user1 = new User();
    System.out.println(user1.hashCode());
    User user2 = new User("name", 23, 34.5);
    System.out.println(user2.hashCode());
    User user3 = new User();
    System.out.println(user3.hashCode());
    User user4 = new User();
    user4.setName("");
    System.out.println(user4.hashCode());

    System.out.println(user1 == user3);
    System.out.println(user1.equals(user3));
  }
}

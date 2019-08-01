package cn.zhuht.jdk8test.collection;

import cn.zhuht.jdk8test.pojo.User;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author zhuhaitao
 * @date 2019/8/1 17:06
 */
public class ChineseSortTest {
  public static void main(String[] args) {
    List<User> list = getList();
    Collections.sort(list,(User u1,User u2)-> Collator.getInstance(Locale.CHINESE).compare(u1.getName(),u2.getName()));
    System.out.println(list);
  }

  public static List<User> getList(){
    User user1 = new User("张三",14,50.0);
    User user2 = new User("张四",14,50.0);
    User user3 = new User("李四",14,50.0);
    User user4 = new User("王五",14,50.0);
    User user5 = new User("赵六",14,50.0);

    return Arrays.asList(user1,user2,user3,user4,user5);
  }
}

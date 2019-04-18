package cn.zhuht.jdk8test.genericity;

import cn.zhuht.jdk8test.pojo.Dog;
import cn.zhuht.jdk8test.pojo.User;
import cn.zhuht.jdk8test.pojo.enumattribute.VarietyDog;

import java.util.stream.Collector;

/**
 * author zhuhaitao
 * date 2019/3/26 18:04
 **/
public class GenericityTest {
  public static void main(String[] args) {
    User user = new User()
      .setName("jack")
      .setAge(18)
      .setWeight(62.5);
    String str = JsonUtils.objToString(user);
    System.out.println(str);
    User user1 = JsonUtils.parseJsonToObj(str,User.class);

    Dog dog = new Dog()
      .setName("八公")
      .setVariety(VarietyDog.Akita)
      .setAge(8);
    String str2 = JsonUtils.objToString(dog);
    System.out.println(str2);
    Dog dog1 = JsonUtils.parseJsonToObj(str2,Dog.class);
  }
}

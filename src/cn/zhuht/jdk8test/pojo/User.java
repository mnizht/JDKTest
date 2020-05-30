package cn.zhuht.jdk8test.pojo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * author zhuhaitao
 * date 2019/3/26 18:05
 **/
@Data
@Accessors(chain = true)
public class User {
  private String name;
  private Integer age;
  private Double weight;
  private LocalDateTime birthday;

  public User(String name, Integer age, Double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public User(String name, Integer age, Double weight, LocalDateTime birthday) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.birthday = birthday;
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public User() {
  }

  public static String fetchGroupKey(User user) {
    return user.getName() + user.getAge();
  }
}

package cn.zhuht.jdk.generic.pojo;

/**
 * @author haitao zhu
 * @date 2020/7/11 17:18
 */
public class Person {
  public Person(String name) {
    this.name = name;
  }

  public Person(String name, Integer age, Boolean gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String name;
  public Integer age;
  public Boolean gender;
}

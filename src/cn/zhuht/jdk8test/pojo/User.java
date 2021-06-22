package cn.zhuht.jdk8test.pojo;


import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * author zhuhaitao
 * date 2019/3/26 18:05
 **/
@Accessors(chain = true)
public class User {
  private String name;
  private String oldName;
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

  public String getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  public Double getWeight() {
    return this.weight;
  }

  public LocalDateTime getBirthday() {
    return this.birthday;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setAge(Integer age) {
    this.age = age;
    return this;
  }

  public User setWeight(Double weight) {
    this.weight = weight;
    return this;
  }

  public User setBirthday(LocalDateTime birthday) {
    this.birthday = birthday;
    return this;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof User)) return false;
    final User other = (User) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    final Object this$age = this.getAge();
    final Object other$age = other.getAge();
    if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
    final Object this$weight = this.getWeight();
    final Object other$weight = other.getWeight();
    if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) return false;
    final Object this$birthday = this.getBirthday();
    final Object other$birthday = other.getBirthday();
    if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof User;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $age = this.getAge();
    result = result * PRIME + ($age == null ? 43 : $age.hashCode());
    final Object $weight = this.getWeight();
    result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
    final Object $birthday = this.getBirthday();
    result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
    return result;
  }

  public String toString() {
    return "User(name=" + this.getName() + ", age=" + this.getAge() + ", weight=" + this.getWeight() + ", birthday=" + this.getBirthday() + ")";
  }

  public User setOldName(String oldName) {
    this.oldName = oldName;
    return this;
  }

  public String getOldName() {
    return oldName;
  }
}

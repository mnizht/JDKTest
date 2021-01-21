package cn.zhuht.jdk8test.pojo;

import cn.zhuht.jdk8test.pojo.enumattribute.VarietyDog;
import lombok.experimental.Accessors;

/**
 * author zhuhaitao
 * date 2019/3/27 14:42
 **/
@Accessors(chain = true)
public class Dog {
  private String name;
  private VarietyDog variety;
  private Integer age;

  public Dog() {
  }

  public String getName() {
    return this.name;
  }

  public VarietyDog getVariety() {
    return this.variety;
  }

  public Integer getAge() {
    return this.age;
  }

  public Dog setName(String name) {
    this.name = name;
    return this;
  }

  public Dog setVariety(VarietyDog variety) {
    this.variety = variety;
    return this;
  }

  public Dog setAge(Integer age) {
    this.age = age;
    return this;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof Dog)) return false;
    final Dog other = (Dog) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    final Object this$variety = this.getVariety();
    final Object other$variety = other.getVariety();
    if (this$variety == null ? other$variety != null : !this$variety.equals(other$variety)) return false;
    final Object this$age = this.getAge();
    final Object other$age = other.getAge();
    if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Dog;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $variety = this.getVariety();
    result = result * PRIME + ($variety == null ? 43 : $variety.hashCode());
    final Object $age = this.getAge();
    result = result * PRIME + ($age == null ? 43 : $age.hashCode());
    return result;
  }

  public String toString() {
    return "Dog(name=" + this.getName() + ", variety=" + this.getVariety() + ", age=" + this.getAge() + ")";
  }
}

package cn.zhuht.jdk.generic.pojo;

/**
 * @author haitao zhu
 * @date 2020/7/11 17:19
 */
public class Student extends Person {
  public String school;

  public Student(String name, String school, String grade) {
    super(name);
    this.school = school;
    this.grade = grade;
  }

  public String grade;

  public Student(String name) {
    super(name);
  }

  public Student(String name, Integer age, Boolean gender) {
    super(name, age, gender);
  }
}

package cn.zhuht.jdk.generic.wildcard;

import cn.zhuht.jdk.generic.pojo.Person;
import cn.zhuht.jdk.generic.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/7/11 15:40
 * <p>
 * 泛型通配符
 */
public class GenericWildcard {
  public static void main(String[] args) {
    Person p = new Person("pp");
    Student s = new Student("ss");

    Person[] p1 = new Person[1];
    p1[0] = p;

    ArrayList<Person> p2 = new ArrayList<>();
    p2.add(p);

    Student[] s1 = new Student[1];
    s1[0] = s;

    ArrayList<Student> s2 = new ArrayList<>();
    s2.add(s);

    //method01 使用泛型数组参数,所以p2 和s2 都正确
    method01(p2);
    method01(s2);

    // 由于数组的可协变性，虽然 method02 的参数数 Person 数组，但Student extends Person,所以传s1 也对，类似于多态
    method02(p1);
    method02(s1);

    // 集合没有协变性，所以method03 只能接受p2； 泛型通配符可以解决这个问题
    method03(p2);
//    method03(s2);  会报错

    // 向下限定，可以
    method04(p2);
    method04(s2);

    List<Object> o2 = new ArrayList<>();
    method05(o2);
    method05(p2);
//    method05(s2);  会报错，

  }

  // 方法泛型
  public static void method01(List<?> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }
  }

  // 数组的可协变性
  public static void method02(Person[] ps) {
    for (Person p : ps) {
      System.out.println(p);
    }
  }

  public static void method03(List<Person> list) {
    for (Person p : list) {
      System.out.println(p);
    }
  }

  // 向下限定
  public static void method04(List<? extends Person> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }
  }

  // 向上限定
  public static void method05(List<? super Person> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }
  }
}

package cn.zhuht.jdk8test.lambda;

import cn.zhuht.jdk8test.pojo.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * author zhuhaitao
 * date 2019/2/21 10:46
 *
 * Lambda 表达式主要用来定义行内执行的方法类型接口
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化编程能力。
 * Lambda 表达式中不允许声明与外部变量同名的变量或参数
 * Lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
 * Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
 **/
public class LambdaTest {
  public static void main(String[] args) {
    groupSort();
  }

  public static void test(){
    LambdaTest test = new LambdaTest();
//    int a = 10;
//    int b = 5;
    //变量在此处声明的话，一下lambda表达式编译出错

    //类型声明
    MathOperation addition = (int a, int b) -> a + b;
    //不用类型声明
    MathOperation subtraction = (a, b) -> a - b;
    int num = 0;
    //大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> {
      //num ++;
      //lambda 表达式中引用外部变量时，会默认它是final的无法更改，直接修改编译不通过
      //可以把要修改的变量放在数组或集合或对象属性中，这样可以修改
      return a * b;
    };
    //没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;
    int a = 10;
    int b = 5;
    System.out.println("10 + 5 = "+test.operation(a,b,addition));
    System.out.println("10 - 5 = "+test.operation(a,b,subtraction));
    System.out.println("10 * 5 = "+test.operation(a,b,multiplication));
    System.out.println("10 / 5 = "+test.operation(a,b,division));

    //不用括号
    GreetingService greetService1 = message-> System.out.println("Hello "+message);
    //用括号
    GreetingService greetService2 = (message)-> System.out.println("Hello "+message);

    greetService1.sayMessage("World");
    greetService2.sayMessage("new world");
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  interface GreetingService {
    void sayMessage(String message);
  }

  private int operation(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }

  public static void groupSort(){
    User user1 = new User("zhao",13);
    User user2 = new User("zhao",11);
    User user3 = new User("zhao",13);
    User user4 = new User("qian",10);
    User user5 = new User("qian",65);
    User user6 = new User("qian",35);
    User user7 = new User("sun",20);
    Map<String, List<User>> collect = Arrays.asList(user1, user2, user3, user4, user5, user6, user7).stream().sorted(Comparator.comparing(User::getAge))
      .collect(Collectors.groupingBy(User::getName));
    System.out.println(collect);
  }
}

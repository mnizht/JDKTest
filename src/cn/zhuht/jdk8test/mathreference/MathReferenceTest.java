package cn.zhuht.jdk8test.mathreference;

import java.util.Arrays;
import java.util.List;

/**
 * author zhuhaitao
 * date 2019/2/21 11:55
 **/
public class MathReferenceTest {
  public static void main(String[] args) {
    //构造器引用：它的语法是 Class::new, 或者Class<T>::new
    //与函数式接口相结合，自动与函数式接口中方法兼容
    //可以把构造器引用赋值给定义的方法
    //使用条件：构造器参数列表要与接口中抽象方法参数列表一致
    final Car car = Car.create(Car::new);
    final List<Car> cars = Arrays.asList(car);
    //静态方法引用:它的语法是 Class::static_method
    cars.forEach(Car::collide);
    //特定类的任意对象方法的引用:Class::method
    cars.forEach(Car::repair);
    //特定对象的方法引用:它的语法是 instance::method
    final Car police = Car.create(Car::new);
    cars.forEach(police::follow);

  }
}

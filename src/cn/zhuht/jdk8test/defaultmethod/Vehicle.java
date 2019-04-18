package cn.zhuht.jdk8test.defaultmethod;

/**
 * author zhuhaitao
 * date 2019/2/21 15:56
 **/
public interface Vehicle {
  //简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
  //我们只需在方法名前面加个 default 关键字即可实现默认方法。
  default void print(){
    System.out.println("我是一辆车！");
  }
}

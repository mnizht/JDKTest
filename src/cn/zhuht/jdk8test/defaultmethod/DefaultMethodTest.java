package cn.zhuht.jdk8test.defaultmethod;

/**
 * author zhuhaitao
 * date 2019/2/21 15:58
 **/

public class DefaultMethodTest implements Vehicle,FourWheeler {
  // 一个实现了多个接口，且这些接口有相同的默认方法
  // 解决方案一：创建自己的默认方法，来覆盖接口的默认方法

  public void print(){
    System.out.println("我是一辆四轮汽车！");
  }

  //解决方案二：使用super来调用指定接口的默认函数
//  public void print(){
//    Vehicle.super.print();
//  }
}

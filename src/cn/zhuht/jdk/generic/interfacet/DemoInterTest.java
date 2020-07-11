package cn.zhuht.jdk.generic.interfacet;

import cn.zhuht.jdk.generic.interfacet.GenericInter;

/**
 * @author haitao zhu
 * @date 2020/7/11 15:19
 * <p>
 * 实现泛型接口的类，如果没指定泛型类型，则默认泛型类型都为 Object
 */
//public class DemoInterTest implements GenericInter {
//  @Override
//  public void method(Object o) {
//
//  }
//
//  @Override
//  public void method2(Object o) {
//
//  }
//}

 // 实现类使用了泛型，但是没有明确泛型类型，那这个实现类就变成了泛型类
//public class DemoInterTest<T,E> implements GenericInter<T,E>{
//
//  @Override
//  public void method(T t) {
//
//  }
//
//  @Override
//  public void method2(E e) {
//
//  }
//}

public class DemoInterTest implements GenericInter<String, Integer> {

  @Override
  public void method(String t) {
    System.out.println(t);
  }

  @Override
  public void method2(Integer e) {
    System.out.println(e);
  }
}
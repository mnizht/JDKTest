package cn.zhuht.jdk.generic.classt;

/**
 * @author haitao zhu
 *@date 2020/7/11 15:03
 *
 * 泛型类定义：
 *  泛型加在类名后
 *  <>里面的东西是泛型的形参
 *  T 就是泛型的形参名称，名称只要遵循Java的标识符规范就行
 *  通常泛型形参都是一个大写字母，例 T，E
 *  泛型可以同时定义多个，使用 ',' 隔开
 *
 *
 */


public class GenericType<T> {
  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }

  T t;
}

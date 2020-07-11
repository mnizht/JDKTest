package cn.zhuht.jdk.generic.interfacet;

/**
 * @author haitao zhu
 * @date 2020/7/11 15:14
 * <p>
 * 泛型接口
 * <p>
 * <p>
 * 接口内的属性，都是默认用 public static final 修饰的常量，且要有明确的值，所以接口中不能用泛型定义变量
 * 接口中的方法参数可以使用泛型
 */
public interface GenericInter<T, E> {

  void method(T t);

  void method2(E e);
}

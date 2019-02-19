package cn.zhuht.JDK8Test.FunctionalInterface;

/**
 * author zhuhaitao
 * date 2019/2/19 15:13
 * 函数式接口，就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 我们可以在任意函数式接口上使用@FunctionalInterface注解，这样做可以检查它是否是一个函数式接口，
 * 同时javadoc也会包含一条声明，说明它是一个函数式接口。
 **/
//函数式接口中使用泛型
@FunctionalInterface
public interface MyFunc<T> {
   T getValue(T t);
}

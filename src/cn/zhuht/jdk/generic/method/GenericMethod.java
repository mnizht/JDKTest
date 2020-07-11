package cn.zhuht.jdk.generic.method;

/**
 * @author haitao zhu
 * @date 2020/7/11 15:29
 * <p>
 * 泛型方法的泛型是加在返回值类型前面
 */
public class GenericMethod {

  public static <T, E> void method(T t) {
    System.out.println(t);
  }


  public static void main(String[] args) {
    method("ssss");
  }
}

package cn.zhuht.jdk.generic;

import cn.zhuht.jdk.generic.classt.GenericType;

/**
 * @author haitao zhu
 * @date 2020/7/11 15:09
 */
public class Test {
  public static void main(String[] args) {
    // 泛型类new 时不指定泛型类型，默认泛型类型是 Object
//    GenericType genericType = new GenericType();
//    genericType.setT("sss");
//    Object t = genericType.getT();

    GenericType<String> genericType = new GenericType<>();
    genericType.setT("ssss");
    String t = genericType.getT();

  }
}

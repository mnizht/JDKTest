package cn.zhuht.jdk.generic;

import cn.zhuht.jdk.generic.interfacet.DemoInterTest;

import java.util.ArrayList;

/**
 * @author haitao zhu
 * @date 2020/7/11 14:40
 */
public class Demo1 {
  public static void main(String[] args) {
    // 只写左边的泛型就可以。 jdk 1.7后泛型推断，可以根据左边推断出泛型
    ArrayList<String> list = new ArrayList<>();
//    list.add(1);
    list.add("aa");

    // 仅右边加了泛型。是无效的
    ArrayList list2 = new ArrayList<String>();
    list2.add(1);

    // 左右都加，以左边为准。左右不同会报错
//    ArrayList<String> list3 = new ArrayList<Integer>();

    DemoInterTest demoInterTest = new DemoInterTest();
    demoInterTest.method("ss");
  }
}

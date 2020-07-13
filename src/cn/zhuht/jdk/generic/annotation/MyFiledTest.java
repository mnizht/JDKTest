package cn.zhuht.jdk.generic.annotation;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author haitao zhu
 * @date 2020/7/13 18:19
 * 通过反射获取注解
 */
public class MyFiledTest {

  // 使用我们自定义的注解
  @MyFiled(description = "用户名", length = 12)
  private String userName;

  private int age;

  @Test
  public void testMyField() {
    // 获取类模板
    Class c = MyFiledTest.class;
    // 获取所有字段
    for (Field f : c.getDeclaredFields()) {
      if (f.isAnnotationPresent(MyFiled.class)) {
        MyFiled annotation = f.getAnnotation(MyFiled.class);
        System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() + "]");

      }
    }

  }
}

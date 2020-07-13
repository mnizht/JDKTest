package cn.zhuht.jdk.generic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author haitao zhu
 * @date 2020/7/13 18:15
 * 注解测试
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFiled {
  String description();

  int length();
}

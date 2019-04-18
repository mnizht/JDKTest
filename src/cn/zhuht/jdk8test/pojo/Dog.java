package cn.zhuht.jdk8test.pojo;

import cn.zhuht.jdk8test.pojo.enumattribute.VarietyDog;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * author zhuhaitao
 * date 2019/3/27 14:42
 **/
@Data
@Accessors(chain = true)
public class Dog {
  private String name;
  private VarietyDog variety;
  private Integer age;
}

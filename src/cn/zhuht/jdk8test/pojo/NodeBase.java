package cn.zhuht.jdk8test.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:14
 */
@Data
@Accessors(chain = true)
public class NodeBase {
  public String id;
  public String preId;
}
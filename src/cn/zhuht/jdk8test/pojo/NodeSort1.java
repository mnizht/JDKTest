package cn.zhuht.jdk8test.pojo;

import lombok.experimental.Accessors;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:15
 */
@Accessors(chain = true)
public class NodeSort1 extends NodeBase {
  private String name;

  public NodeSort1() {
  }

  public String getName() {
    return this.name;
  }

  public NodeSort1 setName(String name) {
    this.name = name;
    return this;
  }

  public String toString() {
    return "NodeSort1(name=" + this.getName() + ")";
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof NodeSort1)) return false;
    final NodeSort1 other = (NodeSort1) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof NodeSort1;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    return result;
  }
}

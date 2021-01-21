package cn.zhuht.jdk8test.pojo;

import lombok.experimental.Accessors;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:15
 */
@Accessors(chain = true)
public class NodeSort2 extends NodeBase {
  private String value;

  public NodeSort2() {
  }

  public String getValue() {
    return this.value;
  }

  public NodeSort2 setValue(String value) {
    this.value = value;
    return this;
  }

  public String toString() {
    return "NodeSort2(value=" + this.getValue() + ")";
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof NodeSort2)) return false;
    final NodeSort2 other = (NodeSort2) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$value = this.getValue();
    final Object other$value = other.getValue();
    if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof NodeSort2;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $value = this.getValue();
    result = result * PRIME + ($value == null ? 43 : $value.hashCode());
    return result;
  }
}

package cn.zhuht.jdk8test.pojo;

import lombok.experimental.Accessors;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:14
 */
@Accessors(chain = true)
public class NodeBase {
  public String id;
  public String preId;

  public NodeBase() {
  }

  public String getId() {
    return this.id;
  }

  public String getPreId() {
    return this.preId;
  }

  public NodeBase setId(String id) {
    this.id = id;
    return this;
  }

  public NodeBase setPreId(String preId) {
    this.preId = preId;
    return this;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof NodeBase)) return false;
    final NodeBase other = (NodeBase) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    final Object this$preId = this.getPreId();
    final Object other$preId = other.getPreId();
    if (this$preId == null ? other$preId != null : !this$preId.equals(other$preId)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof NodeBase;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $preId = this.getPreId();
    result = result * PRIME + ($preId == null ? 43 : $preId.hashCode());
    return result;
  }

  public String toString() {
    return "NodeBase(id=" + this.getId() + ", preId=" + this.getPreId() + ")";
  }
}

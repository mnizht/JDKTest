package cn.zhuht.jdk8test.pojo;

/**
 * @author zhuhaitao
 * @date 2019/7/10 16:32
 */
public class Node implements NodeInterface{

  public Node(String id, String preId, int value) {
    this.id = id;
    this.preId = preId; //上一个节点id
    this.value = value;
  }

  private String id;
  private int value;
  private String preId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getPreId() {
    return preId;
  }

  public void setPreId(String preId) {
    this.preId = preId;
  }

  public String toString() {
    return "{id:" + id + ",preId:" + preId + ",value:" + value + "}";
  }

}

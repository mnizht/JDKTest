package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.genericity.JsonUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZSP
 */
public class OrgNodeDTO implements Serializable {

  public OrgNodeDTO() {
  }

  public OrgNodeDTO(String orgNum) {
    this.orgNum = orgNum;
  }

  /**
   * 机构编码
   */
  private String orgNum;
  /**
   * 子机构
   */
  private List<? super OrgNodeDTO> children = new ArrayList<>();


  public static void main(String[] args) {
    MyOrgNodeDTO myOrgNodeDTO = new MyOrgNodeDTO("00");
    MyOrgNodeDTO myOrgNodeDTO1 = new MyOrgNodeDTO("0001");
    MyOrgNodeDTO myOrgNodeDTO2 = new MyOrgNodeDTO("0002");
    MyOrgNodeDTO myOrgNodeDTO3 = new MyOrgNodeDTO("000101");

    ArrayList<MyOrgNodeDTO> objects = new ArrayList<>();
    objects.add(myOrgNodeDTO);
    objects.add(myOrgNodeDTO1);
    objects.add(myOrgNodeDTO2);
    objects.add(myOrgNodeDTO3);

    List<MyOrgNodeDTO> myOrgNodeDTOS = OrgNode2TreeUtils.node2Tree(objects);
    System.out.println(JsonUtils.objToString(myOrgNodeDTOS));
  }

  public String getOrgNum() {
    return this.orgNum;
  }

  public List<? super OrgNodeDTO> getChildren() {
    return this.children;
  }

  public void setOrgNum(String orgNum) {
    this.orgNum = orgNum;
  }

  public void setChildren(List<? super OrgNodeDTO> children) {
    this.children = children;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof OrgNodeDTO)) return false;
    final OrgNodeDTO other = (OrgNodeDTO) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$orgNum = this.getOrgNum();
    final Object other$orgNum = other.getOrgNum();
    if (this$orgNum == null ? other$orgNum != null : !this$orgNum.equals(other$orgNum)) return false;
    final Object this$children = this.getChildren();
    final Object other$children = other.getChildren();
    if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof OrgNodeDTO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $orgNum = this.getOrgNum();
    result = result * PRIME + ($orgNum == null ? 43 : $orgNum.hashCode());
    final Object $children = this.getChildren();
    result = result * PRIME + ($children == null ? 43 : $children.hashCode());
    return result;
  }

  public String toString() {
    return "OrgNodeDTO(orgNum=" + this.getOrgNum() + ", children=" + this.getChildren() + ")";
  }
}

class OrgNode2TreeUtils {

  public OrgNode2TreeUtils() {
  }

  public static <T extends OrgNodeDTO> List<T> node2Tree(List<T> nodes) {
    List<T> retList = new ArrayList<>();
    for (T parent : nodes) {
      if ("00".equals(parent.getOrgNum())) {
        retList.add(findChildren(parent, nodes));
      }
    }


    return retList;
  }

  private static <T extends OrgNodeDTO> T findChildren(T parent, List<T> treeNodes) {
    for (T child : treeNodes) {
      if (parent.getOrgNum().equals(child.getOrgNum().substring(0, child.getOrgNum().length() - 2))) {
        if (parent.getChildren() == null) {
          parent.setChildren(new ArrayList<>());
        }

        T children = findChildren(child, treeNodes);
        parent.getChildren().add(children);
      }
    }
    return parent;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof OrgNode2TreeUtils)) return false;
    final OrgNode2TreeUtils other = (OrgNode2TreeUtils) o;
    if (!other.canEqual((Object) this)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof OrgNode2TreeUtils;
  }

  public int hashCode() {
    int result = 1;
    return result;
  }

  public String toString() {
    return "OrgNode2TreeUtils()";
  }
}

class MyOrgNodeDTO extends OrgNodeDTO {
  public MyOrgNodeDTO(String orgNum) {
    super(orgNum);
  }
}

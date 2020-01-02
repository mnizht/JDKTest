package cn.zhuht.jdk8test.pojo;

/**
 * @author zhuhaitao
 * @date 2020/1/2 10:50
 */
public class Org {
  public Org(String orgNum) {
    this.orgNum = orgNum;
  }

  private String orgNum;

  public String getOrgNum() {
    return orgNum;
  }

  public void setOrgNum(String orgNum) {
    this.orgNum = orgNum;
  }

  @Override
  public String toString() {
    return "Org{" +
      "orgNum='" + orgNum + '\'' +
      '}';
  }
}

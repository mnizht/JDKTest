package cn.zhuht.demo;

/**
 * @author zhuhaitao
 * @date 2019/8/26 17:04
 */
public class StringDemo {
  public static void main(String[] args) {
      String CHANGE_RECORD_REMARK_DES = "变更(%d)个学员备注标签";
    System.out.println(String.format(CHANGE_RECORD_REMARK_DES,7));
  }
}

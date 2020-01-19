package cn.zhuht.demo;

/**
 * @author zhuhaitao
 * @date 2019/8/26 17:04
 */
public class StringDemo {
  public static void main(String[] args) {
    String CHANGE_RECORD_REMARK_DES = "变更(%d)个学员备注标签";
    System.out.println(String.format(CHANGE_RECORD_REMARK_DES, 7));

    String name = "李伊曼";
    String str1 = "李";
    String str2 = "伊";
    String str3 = "曼";
    String str4 = "伊曼";
    String str5 = "李伊";
    String str6 = "李伊曼";
    String str7 = "李曼";
    String str8 = "佚名";

    System.out.println(name.contains(str1));
    System.out.println(name.contains(str2));
    System.out.println(name.contains(str3));
    System.out.println(name.contains(str4));
    System.out.println(name.contains(str5));
    System.out.println(name.contains(str6));
    System.out.println(name.contains(str7));
    System.out.println(name.contains(str8));
    System.out.println("".contains(str7));

  }
}

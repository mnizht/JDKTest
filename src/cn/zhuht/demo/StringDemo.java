package cn.zhuht.demo;

import java.util.Arrays;

/**
 * @author zhuhaitao
 * @date 2019/8/26 17:04
 */
public class StringDemo {
  public static void main(String[] args) {

    method04();
  }

  public static void method04() {
    String str = "string: %s";
    String format = String.format(str, "null");
    System.out.println(format);
  }

  public static void method03() {
    String purpose = "夯实基础";
    String[] split = purpose.split(",");
    System.out.println(split.length);
    Arrays.stream(split).forEach(System.out::println);
  }

  public static void method02() {
    String name = String.format("%%%s%%", "name");
    System.out.println(name);
  }

  public static void method01() {
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

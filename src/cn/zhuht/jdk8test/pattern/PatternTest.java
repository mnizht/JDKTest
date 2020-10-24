package cn.zhuht.jdk8test.pattern;

import java.util.regex.Pattern;

/**
 * @author zhuhaitao
 * @date 2019/7/27 11:30
 */
public class PatternTest {
  public static void main(String[] args) {

    method02();
  }

  public static void method03() {
    String REGEX_MOBILE = "^[1]([3-9])[0-9]{9}$";
    String phone = "157-3731-5814";
    System.out.println(Pattern.compile(REGEX_MOBILE).matcher(phone).matches());

  }

  public static void method02() {
    String REGEX_MOBILE_PHONE = "^(0|86|17951)?(13[0-9]|14[3579]|15[012356789]|166|17[01235678]|18[0-9]|19[1789])\\s{0,1}[0-9]{4}\\s{0,1}[0-9]{4}$|^(0[0-9]{2,3}-?)?[0-9]{7,8}$|^400-?\\d{3}-?\\d{4}$";

    String phone = "19737315814";
//    phone = phone.replaceAll("\\s+", "");
//    System.out.println(phone);
    System.out.println(Pattern.compile(REGEX_MOBILE_PHONE).matcher(phone).matches());

  }

  public static void method01() {
    String REGEX_CHINESE = "^[\\u4E00-\\u9FA5A-Za-z ]{2,10}$";
    String REGEX_CHINESE2 = "^[\u4e00-\u9fa5]+$";


    String name = "朱海涛一二三四五六七八";
    String enName = "Michael Jackson";
    System.out.println(Pattern.compile(REGEX_CHINESE).matcher(name).matches());
    System.out.println(Pattern.compile(REGEX_CHINESE).matcher(enName).matches());
    System.out.println(Pattern.compile(REGEX_CHINESE2).matcher(name).matches());
    System.out.println(name.length());
  }
}

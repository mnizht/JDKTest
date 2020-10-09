package cn.zhuht.jdk8test.pattern;

import java.util.regex.Pattern;

/**
 * @author zhuhaitao
 * @date 2019/7/27 11:30
 */
public class PatternTest {
  public static void main(String[] args) {
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

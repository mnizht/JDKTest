package cn.zhuht.jdk8test.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuhaitao
 * @date 2019/10/29 10:24
 */
public class MapTest {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("aa", "aaa");
    String bb = map.get("bb");
    System.out.println(bb);

    String num = "00010203";
    System.out.println(num.substring(0,num.length()-2));
    System.out.println(num.substring(0,num.length()-4));
    System.out.println(num.substring(0,2));
  }
}

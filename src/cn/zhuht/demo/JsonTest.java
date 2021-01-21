package cn.zhuht.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haitao zhu
 * @date 2020/9/14 10:40
 */
public class JsonTest {
  public static void main(String[] args) {
    method03();
  }

  public static void method03() {
    List<String> list = new ArrayList<>();
    list.add("排课时间段:2020-09-10 13:00-15:00");
    list.add("修改原因:家长异议");
    String s = JSONObject.toJSONString(list);
    System.out.println(s);
  }

  public static void method02() {
    Map<String, String> map = new HashMap<>();
    map.put("排课时间段", "2020-09-10 13:00-15:00");
    map.put("修改原因", "家长异议");
    String s = JSONObject.toJSONString(map);
    System.out.println(s);
  }

  public static void method01() {
    List<String> of = Arrays.asList("aa", "bb");
    String s = JSONObject.toJSONString(of);
    System.out.println(s);
  }
}

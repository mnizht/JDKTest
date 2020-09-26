package cn.zhuht.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/9/14 10:40
 */
public class JsonTest {
  public static void main(String[] args) {
    List<String> of = Arrays.asList("aa","bb");
    String s = JSONObject.toJSONString(of);
    System.out.println(s);
  }
}

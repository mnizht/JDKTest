package cn.zhuht.jdk8test.genericity;

import com.alibaba.fastjson.JSONObject;

/**
 * author zhuhaitao
 * date 2019/3/26 17:48
 **/
public class JsonUtils {
  public static <T> T parseJsonToObj(String json, Class<T> c) {
    return JSONObject.parseObject(json).toJavaObject(c);
  }

  public static String objToString(Object o) {
    return JSONObject.toJSONString(o);
  }
}

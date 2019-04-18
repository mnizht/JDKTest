package cn.zhuht.jdk8test.genericity;

import com.alibaba.fastjson.JSONObject;

/**
 * author zhuhaitao
 * date 2019/3/26 17:48
 **/
public class JsonUtils {
  public static <T> T parseJsonToObj(String json,Class<T> c){
    JSONObject jsonObject = JSONObject.parseObject(json);
    return JSONObject.toJavaObject(jsonObject,c);
  }
  public static String objToString(Object o){
    return JSONObject.toJSON(o).toString();
  }
}

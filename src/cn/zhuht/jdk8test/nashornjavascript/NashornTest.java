package cn.zhuht.jdk8test.nashornjavascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * author zhuhaitao
 * date 2019/2/22 11:49
 **/
public class NashornTest {
  public static void main(String[] args) {
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
    String name = "Runoob";
    Integer result = null;
    try {
      nashorn.eval("print('"+name+"')");
      result = (int)nashorn.eval("10+2");
    } catch (ScriptException e) {
      e.printStackTrace();
    }
    System.out.println(result);
  }
}

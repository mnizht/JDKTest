package cn.zhuht.jdk8test.defaultmethod;

/**
 * author zhuhaitao
 * date 2019/3/20 11:35
 **/
public interface InterfaceTest {
  void print(String str);

  default int add(int i){
    return i++;
  }
}

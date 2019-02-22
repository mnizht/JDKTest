package cn.zhuht.JDK8Test.DefaultMethod;

/**
 * author zhuhaitao
 * date 2019/2/21 15:56
 **/
public interface FourWheeler {
  default void print(){
    System.out.println("我是一辆四轮车！");
  }
}

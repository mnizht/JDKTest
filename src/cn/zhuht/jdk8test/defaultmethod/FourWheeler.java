package cn.zhuht.jdk8test.defaultmethod;

/**
 * author zhuhaitao
 * date 2019/2/21 15:56
 **/
public interface FourWheeler {
  default void print(){
    System.out.println("我是一辆四轮车！");
  }
}

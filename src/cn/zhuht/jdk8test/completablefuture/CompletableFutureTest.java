package cn.zhuht.jdk8test.completablefuture;

import java.util.concurrent.CompletableFuture;


/**
 * author zhuhaitao
 * date 2019/3/22 14:47
 **/
public class CompletableFutureTest {
  public static void main(String[] args) {

  }

  public static void completableFuture(){
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message");

  }
}

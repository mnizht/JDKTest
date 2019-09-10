package cn.zhuht.jdk8test.lambda;

import cn.zhuht.jdk8test.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhuhaitao
 * @date 2019/9/10 15:03
 */
public class EmptyCollectionLambdaTest {
  public static void main(String[] args) {
    List<User> list = new ArrayList<>();
    Set<String> collect = list.stream().map(x -> x.getName()).collect(Collectors.toSet());
    Set<String> collect2 = list.stream().map(x -> x.getAge().toString()).collect(Collectors.toSet());
    collect.addAll(collect2);
    System.out.println(collect);
  }
}

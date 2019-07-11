package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.pojo.NodeBase;
import cn.zhuht.jdk8test.pojo.NodeSort1;
import cn.zhuht.jdk8test.pojo.NodeSort2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:16
 */
public class NodeSort {

  public static void main(String[] args) {
    List<NodeSort1> node1 = getNode1();
    List<NodeSort2> node2 = getNode2();
    System.out.println(node1);
    System.out.println(node2);

    System.out.println("=====================");
    System.out.println(sort(node1));
    System.out.println(sort(node2));

  }

  private static List<NodeSort1> getNode1() {
    NodeSort1 node1 = new NodeSort1();
    node1.setName("name1").setId("01").setPreId("root");
    NodeSort1 node2 = new NodeSort1();
    node2.setName("name2").setId("02").setPreId("01");
    NodeSort1 node3 = new NodeSort1();
    node3.setName("name3").setId("03").setPreId("02");
    NodeSort1 node4 = new NodeSort1();
    node4.setName("name4").setId("04").setPreId("03");
    NodeSort1 node5 = new NodeSort1();
    node5.setName("name5").setId("05").setPreId("04");
    return Arrays.asList(node2, node4, node1, node5, node3);
  }
  private static List<NodeSort2> getNode2() {
    NodeSort2 node1 = new NodeSort2();
    node1.setValue("name1").setId("01").setPreId("root");
    NodeSort2 node2 = new NodeSort2();
    node2.setValue("name2").setId("02").setPreId("01");
    NodeSort2 node3 = new NodeSort2();
    node3.setValue("name3").setId("03").setPreId("02");
    NodeSort2 node4 = new NodeSort2();
    node4.setValue("name4").setId("04").setPreId("03");
    NodeSort2 node5 = new NodeSort2();
    node5.setValue("name5").setId("05").setPreId("04");
    return Arrays.asList(node2, node4, node1, node5, node3);
  }

  public static <T extends NodeBase> List<T> sort(Collection<T> old) {
    List<T> result = new ArrayList<>(old.size());
    String preId = "root";
    for (int i = old.size(); i > 0; i--) {
      for (T t : old) {
        if (preId.equals(t.getPreId())) {
          result.add(t);
          preId = t.getId();
          break;
        }
      }
    }
    return result;
  }
}

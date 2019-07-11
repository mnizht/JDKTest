package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.pojo.Node;
import cn.zhuht.jdk8test.pojo.NodeInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuhaitao
 * @date 2019/7/10 16:31
 */
public class SortNodeList {
  public static void main(String[] args) {
    NodeInterface node1 = new Node("01", "root", 1);
    NodeInterface node2 = new Node("02", "01", 2);
    NodeInterface node3 = new Node("03", "02", 3);
    NodeInterface node4 = new Node("04", "03", 4);
    NodeInterface node5 = new Node("05", "04", 5);

    List<NodeInterface> list = Arrays.asList(node2, node4, node1, node5, node3);
    for (NodeInterface n : list) {
      System.out.println(n.toString());
    }


//    try {
//      list = genericSort(list);
//    } catch (IllegalAccessException e) {
//      e.printStackTrace();
//    } catch (NoSuchFieldException e) {
//      e.printStackTrace();
//    }
//    for (NodeInterface n : list) {
//      System.out.println(n.toString());
//    }
    list = sortInterface(list);
    for (NodeInterface n : list) {
      System.out.println(n.toString());
    }
  }


  public static List<Node> sort(List<Node> oldList) {
    List<Node> list = new ArrayList<>();
    String preId = "root";
    for (int i = oldList.size(); i > 0; i--) {
      for (Node n : oldList) {
        if (preId.equals(n.getPreId())) {
          list.add(n);
          preId = n.getId();
          break;
        }
      }
    }
    return list;
  }

  public static <T> List<T> genericSort(List<T> oldList) throws IllegalAccessException, NoSuchFieldException {
    List<T> list = new ArrayList<>();
    String preId = "root";
    Field f1 = null;
    Field f2 = null;

    f1 = oldList.get(0).getClass().getDeclaredField("preId");
    f2 = oldList.get(0).getClass().getDeclaredField("id");

    f1.setAccessible(true);
    for (int i = oldList.size(); i > 0; i--) {
      for (T t : oldList) {

        if (preId.equals((String) f1.get(t))) {
          list.add(t);
          preId = (String) f2.get(t);
          break;
        }
      }

    }
    return list;
  }

  private static List<NodeInterface> sortInterface(List<NodeInterface> oldList) {
    List<NodeInterface> list = new ArrayList<>();
    String preId = "root";
    for (int i = oldList.size(); i > 0; i--) {
      for (NodeInterface n : oldList) {
        if (preId.equals(n.getPreId())) {
          list.add(n);
          preId = n.getId();
          break;
        }
      }
    }
    return list;
  }

}

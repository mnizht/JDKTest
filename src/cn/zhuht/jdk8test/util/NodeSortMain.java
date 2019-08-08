package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.pojo.Node;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuhaitao
 * @date 2019/7/11 11:30
 */
public class NodeSortMain {
  public static void main(String[] args) {
    List<Node> list = getList();
    System.out.println(list.toString());
    List<Node> newList = sortByParentId(list,"root","id","preId");
    System.out.println(newList);
  }

  private static List<Node> getList(){
    Node node1 = new Node("01", "root", 1);
    Node node2 = new Node("02", "01", 2);
    Node node3 = new Node("03", "02", 3);
    Node node4 = new Node("04", "03", 4);
    Node node5 = new Node("05", "04", 5);

    return Arrays.asList(node2, node4, node1, node5, node3);
  }

  /**
   * parentId排序 算法复杂度O2
   */
  public static <T> List<T> sortByParentId(List<T> list, Object rootValue, String idFieldName, String pidFieldName) {
    if (list.isEmpty()) {
      return Collections.emptyList();
    }
    Class entityClass = list.get(0).getClass();

    Field idField = null;
    try {
      idField = entityClass.getDeclaredField(idFieldName);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    idField.setAccessible(true);
    Field pidField = null;
    try {
      pidField = entityClass.getDeclaredField(pidFieldName);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    pidField.setAccessible(true);
      // pid map
      Map<Object, T> idEntityMap = new HashMap<>(list.size() - 1);
      T node = null;
      for (T entity : list) {
        Object preId = null;
        try {
          preId = pidField.get(entity);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
        if (node == null && preId.equals(rootValue)) {
          //root节点
          node = entity;
          continue;
        }
        if (node != null && preId.equals(rootValue)) {
          System.out.println("发现多个根节点");
          return Collections.emptyList();
        }
        //其他节点
        idEntityMap.put(preId, entity);
      }
      List<T> result = new ArrayList<>(list.size());

      int i = 0;
      int maxCount = 10000;
      do {
        Object id = null;
        try {
          id = idField.get(node);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
        result.add(node);
        node = idEntityMap.get(id);
        i++;
        if (i > maxCount) {
          System.out.println("超出最大循环次数");
          return Collections.emptyList();
        }
      } while (node != null);
      return result;

  }
}

package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.genericity.JsonUtils;
import cn.zhuht.jdk8test.pojo.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhaitao
 * @date 2019/11/5 17:22
 */
public class List2Tree {
  public static void main(String[] args) {
    TreeNode t1 = new TreeNode("1", "p1", "0");
    TreeNode t2 = new TreeNode("2", "p2", "0");
    TreeNode t3 = new TreeNode("3", "s11", "1");
    TreeNode t4 = new TreeNode("4", "s12", "1");
    TreeNode t5 = new TreeNode("5", "s21", "2");
    TreeNode t6 = new TreeNode("6", "s22", "2");
    TreeNode t7 = new TreeNode("7", "s23", "2");
    TreeNode t8 = new TreeNode("8", "d51", "5");
    TreeNode t9 = new TreeNode("9", "d52", "5");
    TreeNode t10 = new TreeNode("10", "d61", "6");

    List<TreeNode> treeList = new ArrayList<>();
//    Collections.addAll(treeList, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    TreeNode root = new TreeNode("1", "0-1", "0");
    treeList.add(root);
    for (int i = 2, j = 0; i < 99999; i++) {
      j = i / 10 == 0 ? i : i / 10;
      treeList.add(
        new TreeNode(String.valueOf(i), String.format("%d-%d", j, i), String.valueOf(j))
      );
    }

//    long m1Start = System.currentTimeMillis();
//    System.out.println(JsonUtils.objToString(toTree01(treeList)));
//    long m1End = System.currentTimeMillis();
//    System.out.println("m1:" + (m1End - m1Start));
    long m2Start = System.currentTimeMillis();
    System.out.println(JsonUtils.objToString(toTree01(treeList)));
    long m2End = System.currentTimeMillis();
    System.out.println("m2:" + (m2End - m2Start));

    //递归效率更高，随着数据量的增加，递归的优势愈发的明显

  }

  /**
   * 方案一：使用双层循环实现
   */
  public static List<TreeNode> toTree01(List<TreeNode> treeNodes) {
    List<TreeNode> retList = new ArrayList<>();

    for (TreeNode parent : treeNodes) {
      if ("0".equals(parent.getParentId())) {
        retList.add(parent);
      }
      for (TreeNode child : treeNodes) {
        if (child.getParentId().equals(parent.getId())) {
          if (parent.getChildren() == null) {
            parent.setChildren(new ArrayList<>());
          }
          parent.getChildren().add(child);
        }
      }
    }
    return retList;
  }

  /**
   * 方案二：使用递归实现
   */
  public static List<TreeNode> toTree02(List<TreeNode> treeNodes) {
    List<TreeNode> retList = new ArrayList<>();
    for (TreeNode parent : treeNodes) {
      if ("0".equals(parent.getParentId())) {
        retList.add(findChildren(parent, treeNodes));
      }
    }
    return retList;
  }

  private static TreeNode findChildren(TreeNode parent, List<TreeNode> treeNodes) {
    for (TreeNode child : treeNodes) {
      if (parent.getId().equals(child.getParentId())) {
        if (parent.getChildren() == null) {
          parent.setChildren(new ArrayList<>());
        }
        parent.getChildren().add(findChildren(child, treeNodes));
      }
    }
    return parent;
  }
}

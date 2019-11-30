package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.pojo.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhaitao
 * @date 2019/11/5 17:22
 */
public class List2Tree {
  private static int count = 0;
  private static int count2 = 0;

  public static void main(String[] args) {


    List<TreeNode> treeList = new ArrayList<>();

    long startData = System.currentTimeMillis();
    System.out.println("开始构造数据");
    int leaf = 10; //叶子数
    for (int i = 1, level = 1, num = 1, count = 0; i < 1001; i++) {
      if (i > num) {
        count = 0;
        level++;
        num = (int) ((Math.pow(leaf, level) - 1) / (leaf - 1));
      }
      treeList.add(
        new TreeNode(String.format("%d-%d", level, count), String.format("%d-%d", level, count), String.format("%d-%d", level - 1, count / leaf), i)
      );
      count++;
    }
    long endData = System.currentTimeMillis();
    System.out.println("构造数据完成,size：" + treeList.size());
    System.out.println("构造数据完成,耗时：" + (endData - startData));
    long m1Start = System.currentTimeMillis();
    toTree01(treeList);
//    findChildren(treeList.get(0), treeList);
    long m1End = System.currentTimeMillis();
    System.out.println("count:" + count);
    System.out.println("count2:" + count2);
    System.out.println("m1:" + (m1End - m1Start));
//    System.out.println(JsonUtils.objToString(treeList.get(0)));

    //递归效率更高，随着数据量的增加，递归的优势愈发的明显

  }

  /**
   * 方案一：使用双层循环实现
   */
  public static void toTree01(List<TreeNode> treeNodes) {

    for (TreeNode parent : treeNodes) {
      for (TreeNode child : treeNodes) {
        count++;
        if (child.getParentId().equals(parent.getId())) {
          count2++;
//          if (parent.getChildren() == null) {
//            parent.setChildren(new ArrayList<>());
//          }
          parent.getChildren().add(child);
        }
      }
    }
  }

  /**
   * 方案二：使用递归实现
   */
  public static TreeNode findChildren(TreeNode parent, List<TreeNode> treeNodes) {
    for (TreeNode child : treeNodes) {
      count++;
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

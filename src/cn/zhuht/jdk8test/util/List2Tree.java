package cn.zhuht.jdk8test.util;

import cn.zhuht.jdk8test.pojo.dto.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuhaitao
 * @date 2019/11/5 17:22
 */
public class List2Tree {

  public static void main(String[] args) {


    List<Integer> leaves = Arrays.asList(2, 5, 10, 20, 50, 100, 200, 500, 1000);
    leaves.forEach(leaf -> {
        List<Long> timeList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
          List<TreeNode> treeNodesCopy = makeData(leaf);
          long m1Start = System.currentTimeMillis();
          toTree01(treeNodesCopy);
//          findChildren(treeNodesCopy.get(0), treeNodesCopy);
          long m1End = System.currentTimeMillis();
          timeList.add(m1End - m1Start);
        }
        timeList.sort(Long::compareTo);
        long average = (timeList.stream().collect(Collectors.summingLong(x -> x)) - timeList.get(0) - timeList.get(9)) / 8;
        System.out.println("average= " + average);
      }
    );

  }

  /**
   * 方案一：使用双层循环实现
   */
  public static void toTree01(List<TreeNode> treeNodes) {

    for (TreeNode parent : treeNodes) {
      for (TreeNode child : treeNodes) {
        if (child.getParentId().equals(parent.getId())) {
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
      if (parent.getId().equals(child.getParentId())) {
        if (parent.getChildren() == null) {
          parent.setChildren(new ArrayList<>());
        }

        parent.getChildren().add(findChildren(child, treeNodes));
      }
    }
    return parent;
  }

  public static List<TreeNode> makeData(int leaf) {
    List<TreeNode> treeList = new ArrayList<>();

    int layer = 4; //层数
    int count_node = layer == 1 ? 1 : (int) ((Math.pow(leaf, layer) - 1) / (leaf - 1));
    for (int i = 1, level = 1, num = 1, countNum = 0; i <= 10000; i++) {
      if (i > num) {
        countNum = 0;
        level++;
        num = (int) ((Math.pow(leaf, level) - 1) / (leaf - 1));
      }
      treeList.add(
        new TreeNode(String.format("%d-%d", level, countNum), String.format("%d-%d", level, countNum), String.format("%d-%d", level - 1, countNum / leaf), i)
      );
      countNum++;
    }

    return treeList;
  }

}
